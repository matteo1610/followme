package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Direction;

import java.util.List;

/**
 * A class representing a move command to be executed on a swarm of robots.
 *
 * Each robot moves towards the direction (x,y), where x and y are values between -1 and 1 at the given speed s
 * expressed in m/s, it is assumed that at most one between x and y is different from 0.
 */
public final class MoveCommand implements RobotCommand {

    private final Direction direction;
    private final double speed;

    /**
     * Constructs a MoveCommand with the specified direction and speed.
     *
     * @param directionX The direction x-coordinate for movement.
     * @param directionY The direction y-coordinate for movement.
     * @param speed      The speed at which to move the robots.
     */
    public MoveCommand(double directionX, double directionY, double speed) {
        if (directionX == 0 && directionY == 0)
            throw new IllegalArgumentException("In the direction at most one value between x and y must be equal to 0");
        this.direction = new Direction(directionX, directionY);
        this.speed = speed;
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        swarm.parallelStream().forEach(robot -> robot.move(this.direction, this.speed));
    }

    /**
     * Retrieves the direction of movement specified by this command.
     *
     * @return The {@link Direction} of movement.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Retrieves the speed of movement specified by this command.
     *
     * @return The speed of movement.
     */
    public double getSpeed() {
        return speed;
    }
}
