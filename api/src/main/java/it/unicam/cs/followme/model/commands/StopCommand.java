package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;

import java.util.List;

/**
 * A class representing a stop command to be executed on a swarm of robots.
 *
 * Each robot stops its movement. The robot no longer moves but continues to report its condition.
 */
public final class StopCommand implements RobotCommand {

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        swarm.parallelStream().forEach(robot -> robot.stop());
    }
}
