package it.unicam.cs.followme.model.commands;

import java.util.List;

/**
 * An interface representing an iterator for loading and executing a sequence of robot commands.
 */
public interface Iterator extends RobotCommand {

    /**
     * Loads a sequence of robot instructions into the iterator.
     *
     * @param instructions The list of robot commands to load.
     * @throws NullPointerException If the 'instructions' parameter is null.
     */
    void loadInstructions(List<RobotCommand> instructions);

    /**
     * Sets the time allocated for the execution of each individual instruction.
     *
     * @param timeForInstruction The time in milliseconds for each individual instruction.
     */
    void setTimeForInstruction(long timeForInstruction);
}
