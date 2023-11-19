package it.unicam.cs.followme;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Shape;
import it.unicam.cs.followme.model.commands.*;
import it.unicam.cs.followme.util.ShapeParser;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the {@link FollowMeParserHandler} interface and serves as a handler for parsing instructions
 * from a robot program file. It collects and processes the parsed commands and delegates their execution to the {@link
 * Executor}.
 */
public class Handler implements FollowMeParserHandler {

    private Map<String, Shape> shapes;
    private Executor executor;

    /**
     * Constructs a Handler with the swarm of robots and a time for executing robot instructions.
     *
     * @param swarm              The list of robots in the simulation.
     * @param timeForInstruction The time (in millis) for executing robot instructions.
     */
    public Handler(List<Robot> swarm, long timeForInstruction) {
        this.shapes = new HashMap<>();
        this.executor = new Executor(timeForInstruction, swarm);
    }

    @Override
    public void parsingStarted() {
        this.shapes = ShapeParser.parseToShape(Referee.getShapes());
    }

    @Override
    public void parsingDone() {
        this.executor.executeProgram();
    }

    @Override
    public void moveCommand(double[] args) {
        this.executor.addInstruction(new MoveCommand(args[0], args[1], args[2]));
    }

    @Override
    public void moveRandomCommand(double[] args) {
        this.executor.addInstruction(new MoveRandomCommand(args[0], args[1], args[2], args[3], args[4]));
    }

    @Override
    public void signalCommand(String label) {
        this.executor.addInstruction(new SignalCommand(label));
    }

    @Override
    public void unsignalCommand(String label) {
        this.executor.addInstruction(new UnsignalCommand(label));
    }

    @Override
    public void followCommand(String label, double[] args) {
        this.executor.addInstruction(new FollowCommand(label, args[0], args[1]));
    }

    @Override
    public void stopCommand() {
        this.executor.addInstruction(new StopCommand());
    }

    @Override
    public void continueCommand(int s) {
        this.executor.addInstruction(new ContinueCommand(s));
    }

    @Override
    public void repeatCommandStart(int n) {
        this.executor.addIterator(new RepeatIterator(n));
    }

    @Override
    public void untilCommandStart(String label) {
        this.executor.addIterator(new UntilIterator(this.shapes.get(label)));
    }

    @Override
    public void doForeverStart() {
        this.executor.addIterator(new DoForeverIterator());
    }

    @Override
    public void doneCommand() {
        this.executor.rowComplete();
    }

    /**
     * Retrieves the executor responsible for managing and executing tasks.
     *
     * @return The executor responsible for task execution.
     */
    public Executor getExecutor() {
        return this.executor;
    }
}
