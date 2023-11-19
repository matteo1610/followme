package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SignalCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void createSignalWithNoLabel() {
        assertThrows(NullPointerException.class, () -> new SignalCommand(null));
        assertThrows(NullPointerException.class, () -> new SignalCommand(""));
    }

    @Test
    void executeSignalCommand() {
        String signalLabel = "testSignal";
        SignalCommand signalCommand = new SignalCommand(signalLabel);
        signalCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertTrue(robot.containSignal(signalCommand.getSignal()));
        }
    }

    @Test
    void executeSignalCommandWithNoRobots() {
        String signalLabel = "testSignal";
        RobotCommand signalCommand = new SignalCommand(signalLabel);
        assertThrows(NullPointerException.class, () -> signalCommand.execute(null));
        assertThrows(NullPointerException.class, () -> signalCommand.execute(new ArrayList<>()));
    }
}
