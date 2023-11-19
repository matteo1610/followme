package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Signal;

import java.util.List;

/**
 * A class representing a signal command to be executed on a swarm of robots.
 *
 * Each robot signals a particular condition, label is an identifier made up of a sequence of alphanumeric characters
 * and the '_' symbol.
 */
public final class SignalCommand implements RobotCommand {

    private final Signal signal;

    /**
     * Constructs a SignalCommand with the specified label for the signal.
     *
     * @param label The label for the {@link Signal} to be added to the robots.
     */
    public SignalCommand(String label) {
        this.signal = new Signal(label);
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        swarm.parallelStream().forEach(robot -> robot.addSignal(this.signal));
    }

    /**
     * Retrieves the signal that will be added to the robots during the execution of the command.
     *
     * @return The {@link Signal} to be added to the robots.
     */
    public Signal getSignal() {
        return signal;
    }
}
