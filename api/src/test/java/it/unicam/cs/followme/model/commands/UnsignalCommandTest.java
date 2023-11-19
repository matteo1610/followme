package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Signal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnsignalCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void createUnsignalWithNoLabel() {
        assertThrows(NullPointerException.class, () -> new UnsignalCommand(null));
        assertThrows(NullPointerException.class, () -> new UnsignalCommand(""));
    }

    @Test
    void executeUnsignalCommand() {
        String signalLabel = "testSignal";
        for (Robot robot : this.robotSwarm) {
            robot.addSignal(new Signal(signalLabel));
        }
        UnsignalCommand unsignalCommand = new UnsignalCommand(signalLabel);
        unsignalCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertFalse(robot.containSignal(unsignalCommand.getSignal()));
        }
    }

    @Test
    void executeUnsignalCommandWithNoRobots() {
        String signalLabel = "testSignal";
        RobotCommand unsignalCommand = new UnsignalCommand(signalLabel);
        assertThrows(NullPointerException.class, () -> unsignalCommand.execute(null));
        assertThrows(NullPointerException.class, () -> unsignalCommand.execute(new ArrayList<>()));
    }
}
