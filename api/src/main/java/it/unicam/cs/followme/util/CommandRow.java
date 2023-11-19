package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.commands.Iterator;
import it.unicam.cs.followme.model.commands.RobotCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class represents a row of robot instructions in a robot program. It can contain a list of individual robot
 * commands and an optional iterator for repeating commands.
 */
public final class CommandRow {

    private Iterator iterator;
    private List<RobotCommand> instructionList;

    /**
     * Constructs an empty CommandRow with no instructions or iterators.
     */
    public CommandRow() {
        this.iterator = null;
        this.instructionList = new ArrayList<>();
    }

    /**
     * Adds a robot command to the list of instructions in this command row.
     *
     * @param instruction The {@link RobotCommand} to add to the row.
     */
    public void addInstruction(RobotCommand instruction) {
        this.instructionList.add(instruction);
    }

    /**
     * Retrieves the list of robot instructions in this command row.
     *
     * @return The list of robot instructions.
     */
    public List<RobotCommand> getInstructionList() {
        return this.instructionList;
    }

    /**
     * Retrieves the iterator associated with this command row, if one is set.
     *
     * @return The {@link Iterator} associated with this command row, or null if none is set.
     */
    public Iterator getIterator() {
        return this.iterator;
    }

    /**
     * Sets an iterator for this command row. An iterator is used to repeat a set of commands.
     *
     * @param iterator The iterator to set for this command row.
     */
    public void setIterator(Iterator iterator) {
        this.iterator = iterator;
    }
}
