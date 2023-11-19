package it.unicam.cs.followme;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.util.RandomPointGenerator;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class is responsible for managing a swarm of robots in a simulated environment. It serves as the central
 * controller for the robots and facilitates the compilation of environment and program instructions for the simulation.
 */
public class Referee {

    private final List<Robot> swarm;
    private static final List<ShapeData> shapes = new ArrayList<>();
    private final Handler handler;
    private final FollowMeParser parser;

    /**
     * Constructs a Referee with a specified number of robots and a time for robot instructions.
     *
     * @param numberOfRobots       The number of robots to create in the swarm.
     * @param timeForInstruction   The time (in millis) for executing robot instructions.
     * @param width                The width of the area where robots can be generated.
     * @param height               The height of the area where robots can be generated.
     * @throws IllegalArgumentException If the number of robots, the time for each instruction, width, or height is less
     *                                  than 1 or not greater than 0, respectively.
     */
    public Referee(int numberOfRobots, double width, double height, long timeForInstruction) {
        if (numberOfRobots < 1 || timeForInstruction < 1)
            throw new IllegalArgumentException("The number of robots and/or the time for each instruction must be at" +
                    " least 1");
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Area values must be greater than 0");
        this.swarm = IntStream.range(0, numberOfRobots)
                .mapToObj(i -> new Robot(RandomPointGenerator
                        .generatePoint(-width/2, width/2, -height/2, height/2)))
                .toList();
        this.handler = new Handler(this.swarm, timeForInstruction);
        this.parser = new FollowMeParser(this.handler);
    }

    /**
     * Compiles the robot program instructions from a given file.
     *
     * @param program The file containing robot program instructions to be parsed.
     * @throws FollowMeParserException If there is an error parsing the robot program file.
     * @throws IOException             If there is an I/O error reading the file.
     */
    public void compileProgram(File program) throws FollowMeParserException, IOException {
        this.parser.parseRobotProgram(program);
    }

    /**
     * Compiles the environment information from a given file and adds it to the simulation.
     *
     * @param environment   The file containing environment information to be parsed.
     * @throws FollowMeParserException If there is an error parsing the environment file.
     * @throws IOException             If there is an I/O error reading the file.
     */
    public void compileEnvironment(File environment) throws FollowMeParserException, IOException {
        shapes.addAll(this.parser.parseEnvironment(environment));
    }

    /**
     * Retrieves the shapes present in the environment. The environment is assumed to be compiled before executing this
     * method.
     *
     * @return A list of {@link ShapeData} objects representing the shapes in the environment.
     */
    public static List<ShapeData> getShapes() {
        return shapes;
    }

    /**
     * Retrieves the swarm of robots.
     *
     * @return A list of {@link Robot} objects representing the swarm of robots.
     */
    public List<Robot> getInitSwarm() {
        return this.swarm;
    }

    /**
     * Retrieves the executor responsible for managing and executing tasks.
     *
     * @return The executor responsible for task execution.
     */
    public Executor getExecutor() {
        return this.handler.getExecutor();
    }
}
