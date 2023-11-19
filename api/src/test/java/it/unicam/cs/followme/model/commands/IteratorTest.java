package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Rectangle;
import it.unicam.cs.followme.model.Shape;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    void testLoadInstructions() {
        AbstractIterator iterator = new RepeatIterator(3);
        List<RobotCommand> instructions = new ArrayList<>();
        instructions.add(new MoveCommand(1, 1, 2));
        iterator.loadInstructions(instructions);
        assertEquals(instructions, iterator.getInstructions());
    }

    @Test
    void testSetTimeForInstruction() {
        AbstractIterator iterator = new DoForeverIterator();
        long timeForExecution = 1000;
        iterator.setTimeForInstruction(timeForExecution);
        assertEquals(timeForExecution, iterator.getTimeForInstruction());
    }

    @Test
    void createRepeatIterator() {
        int numberOfIterations = 3;
        RepeatIterator iterator = new RepeatIterator(numberOfIterations);
        assertEquals(numberOfIterations, iterator.getNumberOfIterations());
    }

    @Test
    void createRepeatIteratorWithInvalidNumberOfIterations() {
        assertThrows(IllegalArgumentException.class, () -> new RepeatIterator(0));
        assertThrows(IllegalArgumentException.class, () -> new RepeatIterator(-1));
    }

    @Test
    void createUntilIterator() {
        Shape shape = new Rectangle(new Point(5, 5), 3, 6);
        UntilIterator iterator = new UntilIterator(shape);
        assertEquals(shape, iterator.getShape());
    }

    @Test
    void createUntilIteratorWithNullShape() {
        assertThrows(NullPointerException.class, () -> new UntilIterator(null));
    }
}
