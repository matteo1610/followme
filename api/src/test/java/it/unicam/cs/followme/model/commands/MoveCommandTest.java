package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Direction;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void createMoveCommandWithInvalidDirection() {
        Direction direction = new Direction(0.0, 0.0);
        double speed = 2.0;
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(direction.x(), direction.y(), speed));
    }

    @Test
    void executeMoveCommand() {
        Direction direction = new Direction(1.0, 0.0);
        double speed = 2.0;
        MoveCommand moveCommand = new MoveCommand(direction.x(), direction.y(), speed);
        moveCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertTrue(moveCommand.getDirection().equals(robot.getDirection()));
            assertEquals(moveCommand.getSpeed(), robot.getSpeed(), 0.001);
        }
    }

    @Test
    void executeMoveCommandWithNoRobots() {
        Direction direction = new Direction(1.0, 0.0);
        double speed = 2.0;
        RobotCommand moveCommand = new MoveCommand(direction.x(), direction.y(), speed);
        assertThrows(NullPointerException.class, () -> moveCommand.execute(null));
        assertThrows(NullPointerException.class, () -> moveCommand.execute(new ArrayList<>()));
    }
}