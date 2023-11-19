package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.commands.*;
import it.unicam.cs.followme.util.CommandRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandRowTest {

    private CommandRow commandRow;

    @BeforeEach
    void setUp() {
        this.commandRow = new CommandRow();
    }

    @Test
    void testAddInstruction() {
        RobotCommand robotCommand = new MoveCommand(1.0, 1.0, 2.0);
        this.commandRow.addInstruction(robotCommand);
        List<RobotCommand> instructionList = this.commandRow.getInstructionList();
        assertEquals(1, instructionList.size());
        assertTrue(instructionList.contains(robotCommand));
    }

    @Test
    void testSetIterator() {
        Iterator iterator = new RepeatIterator(3);
        this.commandRow.setIterator(iterator);
        assertEquals(iterator, this.commandRow.getIterator());
    }
}
