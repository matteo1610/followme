package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;

import java.util.List;

/**
 * An interface representing a command that can be executed on a swarm of robots.
 */
public interface RobotCommand {

    /**
     * Executes the command on the specified swarm of robots.
     *
     * @param swarm The list of robots on which to execute the command.
     * @throws NullPointerException If the 'swarm' parameter is null.
     */
    void execute(List<Robot> swarm);
}
