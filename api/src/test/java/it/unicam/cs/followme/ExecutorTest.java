package it.unicam.cs.followme;

import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Rectangle;
import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.commands.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExecutorTest {

    private Executor executor;
    private List<Robot> swarm;
    private RobotCommand command;

    @BeforeEach
    void setUp() {
        this.swarm = new ArrayList<>();
        this.command = new MoveCommand(1, 1, 2);
        this.executor = new Executor(1000, swarm);
    }

    @Test
    void testAddInstruction() {
        this.executor.addInstruction(this.command);
        assertEquals(1, this.executor.getInstructions().get(0).getInstructionList().size());
    }

    @Test
    void testAddIterator() {
        Iterator iterator = new RepeatIterator(4);
        this.executor.addIterator(iterator);
        assertNotNull(this.executor.getInstructions().get(1).getIterator());
    }

    @Test
    void testRowComplete() {
        Iterator iterator = new UntilIterator(new Rectangle(new Point(2,2), 3, 6));
        this.executor.addIterator(iterator);
        this.executor.rowComplete();
        assertNull(this.executor.getInstructions().get(0).getIterator());
        assertEquals(1, this.executor.getInstructions().size());
    }

    @Test
    void testIsTerminated() {
        this.executor.executeProgram();
        assertTrue(this.executor.isTerminated());
    }
}
