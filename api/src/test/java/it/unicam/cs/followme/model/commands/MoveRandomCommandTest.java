package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Direction;
import it.unicam.cs.followme.util.DirectionCalculator;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveRandomCommandTest {

    private List<Robot> robotSwarm;

    @BeforeEach
    void setUp() {
        this.robotSwarm = new ArrayList<>();
        this.robotSwarm.add(new Robot(new Point(0.0, 0.0)));
        this.robotSwarm.add(new Robot(new Point(1.0, 1.0)));
    }

    @Test
    void executeMoveRandomCommand() {
        double x1 = -3.0;
        double x2 = 1.0;
        double y1 = -5.0;
        double y2 = 4.0;
        double speed = 2.0;
        MoveRandomCommand moveRandomCommand = new MoveRandomCommand(x1, x2, y1, y2, speed);
        List<Direction> directions = new ArrayList<>();
        for (Robot robot : this.robotSwarm) {
            directions.add(this.robotSwarm.indexOf(robot), DirectionCalculator
                    .calculateDirection(robot.getActualPosition(), moveRandomCommand.getTarget()));
        }
        moveRandomCommand.execute(this.robotSwarm);
        for (Robot robot : this.robotSwarm) {
            assertEquals(directions.get(this.robotSwarm.indexOf(robot)), robot.getDirection());
            assertEquals(moveRandomCommand.getSpeed(), robot.getSpeed(), 0.001);
        }
    }

    @Test
    void executeMoveRandomCommandWithNoRobots() {
        double x1 = -3.0;
        double x2 = 1.0;
        double y1 = -5.0;
        double y2 = 4.0;
        double speed = 2.0;
        RobotCommand moveRandomCommand = new MoveRandomCommand(x1, x2, y1, y2, speed);
        assertThrows(NullPointerException.class, () -> moveRandomCommand.execute(null));
        assertThrows(NullPointerException.class, () -> moveRandomCommand.execute(new ArrayList<>()));
    }
}
