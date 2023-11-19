package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;

import java.util.List;
import java.util.stream.IntStream;

/**
 * A class representing a continue command to be executed on a swarm of robots.
 *
 * Each robot continues to move for s seconds with the same direction and speed.
 */
public final class ContinueCommand implements RobotCommand {

    private final int seconds;

    /**
     * Constructs a ContinueCommand with the specified duration in seconds.
     *
     * @param seconds The duration for which the robots should continue their movement.
     * @throws IllegalArgumentException If the specified duration is less than 1 second.
     */
    public ContinueCommand(int seconds) {
        if (seconds < 1)
            throw new IllegalArgumentException("Attempt to continue the movement of the robot for less than 1 second");
        this.seconds = seconds;
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        IntStream.range(0, this.seconds).forEach(i -> swarm.parallelStream().forEach(robot -> robot.move()));
    }

    /**
     * Retrieves the duration in seconds for which the robots will continue their movement.
     *
     * @return The duration in seconds for the robot movement.
     */
    public int getSeconds() {
        return seconds;
    }
}
