package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void executeStopCommand() {
        StopCommand stopCommand = new StopCommand();
        stopCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertTrue(robot.isStopped());
        }
    }

    @Test
    void executeStopCommandWithNoRobots() {
        StopCommand stopCommand = new StopCommand();
        assertThrows(NullPointerException.class, () -> stopCommand.execute(null));
        assertThrows(NullPointerException.class, () -> stopCommand.execute(new ArrayList<>()));
    }
}
