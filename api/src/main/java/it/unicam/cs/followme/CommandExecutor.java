package it.unicam.cs.followme;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.commands.RobotCommand;

import java.util.List;

/**
 * This class provides a utility for executing a {@link RobotCommand} with a desired execution time on a swarm of
 * robots.
 */
public final class CommandExecutor {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private CommandExecutor() {}

    /**
     * Executes a {@link RobotCommand} on a swarm of robots repeatedly until the desired execution time is met.
     *
     * @param command                    The {@link RobotCommand} to execute.
     * @param swarm                      The list of robots on which the command should be executed.
     * @param desiredExecutionTimeMillis The desired execution time in milliseconds.
     * @throws NullPointerException If the {@code command} is {@code null}.
     */
    public static void execute(RobotCommand command, List<Robot> swarm, long desiredExecutionTimeMillis) {
        if (command == null)
            throw new NullPointerException("Attempt to run a command without specifying it.");
        if (swarm.stream().allMatch(Robot::isStopped)) return;
        long startTime = System.currentTimeMillis();
        long currentTime;
        command.execute(swarm);
        do {
            currentTime = System.currentTimeMillis();
        } while ((currentTime - startTime) < desiredExecutionTimeMillis);
    }
}
