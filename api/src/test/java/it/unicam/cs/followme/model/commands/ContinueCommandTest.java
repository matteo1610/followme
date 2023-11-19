package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContinueCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void createContinueCommandWithInvalidDuration() {
        int seconds = 0;
        assertThrows(IllegalArgumentException.class, () -> new ContinueCommand(seconds));
    }

    @Test
    void executeContinueCommand() {
        int seconds = 3;
        ContinueCommand continueCommand = new ContinueCommand(seconds);
        continueCommand.execute(this.robotSwarm);
        assertEquals(seconds, continueCommand.getSeconds());
    }

    @Test
    void executeContinueCommandWithNoRobots() {
        int seconds = 3;
        RobotCommand continueCommand = new ContinueCommand(seconds);
        assertThrows(NullPointerException.class, () -> continueCommand.execute(null));
        assertThrows(NullPointerException.class, () -> continueCommand.execute(new ArrayList<>()));
    }
}
