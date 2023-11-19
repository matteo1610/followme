package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.CommandExecutor;
import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Shape;

import java.util.List;

/**
 * A class representing a 'Until' iterator. It repeats a sequence of robot commands until a specified condition is met
 * (until a robot is inside an area with the required label).
 */
public final class UntilIterator extends AbstractIterator {

    private final Shape shape;

    /**
     * Constructs an UntilIterator with the specified shape condition.
     *
     * @param shape The shape representing the area with the required label.
     * @throws NullPointerException If the 'shape' parameter is null.
     */
    public UntilIterator(Shape shape) {
        if (shape == null)
            throw new NullPointerException("Attempt to use the until iterator with a label not present in the " +
                    "environment");
        this.shape = shape;
    }

    @Override
    public void execute(List<Robot> swarm) {
        while (swarm.stream().anyMatch(robot -> this.shape.containsPosition(robot.getActualPosition()))) {
            this.instructions.forEach(instruction -> CommandExecutor.execute(instruction, swarm,
                    this.timeForInstruction));
        }
    }

    /**
     * Retrieves the shape representing the area condition.
     *
     * @return The {@link Shape} representing the area condition.
     */
    public Shape getShape() {
        return this.shape;
    }
}
