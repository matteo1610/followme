package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Signal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FollowCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void createFollowWithNoLabel() {
        assertThrows(NullPointerException.class, () -> new FollowCommand(null, 100, 2));
        assertThrows(NullPointerException.class, () -> new FollowCommand("", 50, 1));
    }

    @Test
    void executeFollowCommand() {
        String signalLabel = "testSignal";
        double distance = 2.0;
        double speed = 1.0;
        FollowCommand followCommand = new FollowCommand(signalLabel, distance, speed);
        new SignalCommand(signalLabel).execute(this.robotSwarm);
        followCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertTrue(robot.containSignal(followCommand.getSignal()));
            assertEquals(followCommand.getDistance(), distance, 0.001);
            assertEquals(followCommand.getSpeed(), robot.getSpeed(), 0.001);
        }
    }

    @Test
    void executeFollowCommandWithNoRobots() {
        String signalLabel = "testSignal";
        double distance = 2.0;
        double speed = 1.0;
        RobotCommand followCommand = new FollowCommand(signalLabel, distance, speed);
        assertThrows(NullPointerException.class, () -> followCommand.execute(null));
        assertThrows(NullPointerException.class, () -> followCommand.execute(new ArrayList<>()));
    }
}