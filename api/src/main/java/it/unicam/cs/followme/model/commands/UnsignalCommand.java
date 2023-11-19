package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Signal;

import java.util.List;

/**
 * A class representing an unsignal command to be executed on a swarm of robots.
 *
 * Each robot finishes reporting the condition.
 */
public final class UnsignalCommand implements RobotCommand {

    private final Signal signal;

    /**
     * Constructs an UnsignalCommand with the specified label for the signal to be removed.
     *
     * @param label The label of the signal to be removed from the robots.
     */
    public UnsignalCommand(String label) {
        this.signal = new Signal(label);
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        swarm.parallelStream().forEach(robot -> robot.removeSignal(this.signal));
    }

    /**
     * Retrieves the signal that will be removed from the robots during the execution of the command.
     *
     * @return The {@link Signal} to be removed from the robots.
     */
    public Signal getSignal() {
        return signal;
    }
}
