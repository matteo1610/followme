package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.util.DirectionCalculator;
import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.util.RandomPointGenerator;

import java.util.List;

/**
 * A class representing a random move command to be executed on a swarm of robots.
 *
 * Each robot moves at speed s expressed in m/s towards a position (x,y) randomly chosen in the interval [x1, x2] and
 * [y1, y2].
 */
public final class MoveRandomCommand implements RobotCommand {

    private final Point target;
    private final double speed;

    /**
     * Constructs a MoveRandomCommand with the specified range and speed.
     *
     * @param x1     The lower bound x-coordinate for the range of the target point.
     * @param x2     The upper bound x-coordinate for the range of the target point.
     * @param y1     The lower bound y-coordinate for the range of the target point.
     * @param y2     The upper bound y-coordinate for the range of the target point.
     * @param speed  The speed at which to move the robots towards the randomly generated target.
     */
    public MoveRandomCommand(double x1, double x2, double y1, double y2, double speed) {
        this.target = RandomPointGenerator.generatePoint(new Point(x1, y1), new Point(x2, y2));
        this.speed = speed;
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        swarm.parallelStream().forEach(robot -> robot.move(DirectionCalculator
                .calculateDirection(robot.getActualPosition(), this.target), this.speed));
    }

    /**
     * Retrieves the speed at which the robots will move towards the randomly generated target.
     *
     * @return The speed of movement.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Retrieves the randomly generated target point towards which the robots will move.
     *
     * @return The target {@link Point} for movement.
     */
    public Point getTarget() {
        return target;
    }
}
