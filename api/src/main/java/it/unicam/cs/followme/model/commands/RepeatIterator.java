package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.CommandExecutor;
import it.unicam.cs.followme.model.Robot;

import java.util.List;
import java.util.stream.IntStream;

/**
 * A class representing a 'Repeat' iterator. It repeats a sequence of robot commands a specified number of times.
 */
public final class RepeatIterator extends AbstractIterator {

    private final int numberOfIterations;

    /**
     * Constructs a RepeatIterator with the specified number of iterations.
     *
     * @param numberOfIterations The number of times to repeat the sequence of robot commands.
     * @throws IllegalArgumentException If the 'numberOfIterations' parameter is less than 1.
     */
    public RepeatIterator(int numberOfIterations) {
        if (numberOfIterations < 1)
            throw new IllegalArgumentException("The n value of the repeat iterator must be at least 1.");
        this.numberOfIterations = numberOfIterations;
    }

    @Override
    public void execute(List<Robot> swarm) {
        IntStream.range(0, this.numberOfIterations).forEach(i -> this.instructions.forEach(instruction ->
                CommandExecutor.execute(instruction, swarm, this.timeForInstruction)));
    }

    /**
     * Retrieves the number of iterations for the repeat command.
     *
     * @return The number of times the sequence of robot commands will be repeated.
     */
    public int getNumberOfIterations() {
        return this.numberOfIterations;
    }
}
