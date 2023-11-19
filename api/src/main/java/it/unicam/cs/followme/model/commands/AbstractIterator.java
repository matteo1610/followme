package it.unicam.cs.followme.model.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract base class implementing the Iterator interface for loading and executing a sequence of robot commands.
 */
public abstract class AbstractIterator implements Iterator {

    protected final List<RobotCommand> instructions;
    protected long timeForInstruction;

    /**
     * Constructs an AbstractIterator with an empty list of instructions and a default time constraint for individual
     * instructions.
     */
    public AbstractIterator() {
        this.instructions = new ArrayList<>();
        this.timeForInstruction = 1000;
    }

    @Override
    public void loadInstructions(List<RobotCommand> instructions) {
        if (instructions == null)
            throw new NullPointerException("The 'instructions' parameter cannot be null.");
        this.instructions.addAll(instructions);
    }

    @Override
    public void setTimeForInstruction(long timeForInstruction) {
        this.timeForInstruction = timeForInstruction;
    }

    /**
     * Retrieves the list of loaded robot instructions.
     *
     * @return The list of robot commands loaded into the iterator.
     */
    public List<RobotCommand> getInstructions() {
        return this.instructions;
    }

    /**
     * Retrieves the time constraint for individual instructions.
     *
     * @return The time constraint in milliseconds for each individual instruction.
     */
    public long getTimeForInstruction() {
        return this.timeForInstruction;
    }
}
