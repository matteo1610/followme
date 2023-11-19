package it.unicam.cs.followme;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.commands.Iterator;
import it.unicam.cs.followme.model.commands.RobotCommand;
import it.unicam.cs.followme.util.CommandRow;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an executor for a program that controls a swarm of robots.
 */
public class Executor {

    private List<Robot> swarm;
    private long timeForInstruction;
    private List<CommandRow> instructions;

    /**
     * Constructs an Executor with the given time constraint for individual instructions and a swarm of robots.
     *
     * @param desiredExecutionTimeMillis The time constraint in milliseconds for each individual instruction.
     * @param swarm                      The list of robots on which the instructions should be executed.
     */
    public Executor(long desiredExecutionTimeMillis, List<Robot> swarm) {
        this.swarm = swarm;
        this.timeForInstruction = desiredExecutionTimeMillis;
        this.instructions = new ArrayList<>();
        this.instructions.add(new CommandRow());
    }

    /**
     * Adds an individual {@link RobotCommand} instruction to the current command row.
     *
     * @param instruction The {@link RobotCommand} to be added to the current command row.
     */
    public void addInstruction(RobotCommand instruction) {
        this.instructions.get(this.instructions.size() - 1).addInstruction(instruction);
    }

    /**
     * Adds an {@link Iterator} to create a new command row. When an iterator is added, the current command row is
     * saved, and a new command row is started to hold instructions from the iterator.
     *
     * @param iterator The {@link Iterator} to be added.
     */
    public void addIterator(Iterator iterator) {
        this.instructions.add(new CommandRow());
        this.instructions.get(this.instructions.size() - 1).setIterator(iterator);
    }

    /**
     * Signals the completion of a command row. When this method is called, the current command row is saved, and its
     * instructions are loaded into the associated iterator. The iterator, along with its loaded instructions, is then
     * added to the row below.
     */
    public void rowComplete() {
        Iterator itr = this.instructions.get(this.instructions.size() - 1).getIterator();
        itr.loadInstructions(this.instructions.get(this.instructions.size() - 1).getInstructionList());
        itr.setTimeForInstruction(this.timeForInstruction);
        this.instructions.remove(this.instructions.size() - 1);
        this.instructions.get(this.instructions.size() - 1).addInstruction(itr);
    }

    /**
     * Executes the program by running all stored instructions.
     *
     * @throws RuntimeException If there is an error in compiling the program.
     */
    public void executeProgram() {
        if (this.instructions.size() != 1)
            throw new RuntimeException("Error in compiling the program");
        this.instructions.get(0).getInstructionList().forEach(instruction -> CommandExecutor.execute(instruction,
                this.swarm, this.timeForInstruction));
        this.swarm.forEach(robot -> robot.stop());
    }

    /**
     * Checks whether all robots in the swarm have terminated, meaning they have stopped their actions.
     *
     * @return true if all robots in the swarm have terminated; otherwise, false.
     */
    public boolean isTerminated() {
        return this.swarm.stream().allMatch(Robot::isStopped);
    }

    /**
     * Retrieves the list of command rows containing the program's instructions.
     *
     * @return A list of {@link CommandRow} objects representing the program's instructions.
     */
    public List<CommandRow> getInstructions() {
        return this.instructions;
    }

    /**
     * Retrieves the swarm of robots.
     *
     * @return A list of {@link Robot} objects representing the swarm of robots.
     */
    public List<Robot> getSwarm() {
        return this.swarm;
    }
}
