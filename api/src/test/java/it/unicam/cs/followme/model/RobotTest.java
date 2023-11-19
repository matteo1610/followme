package it.unicam.cs.followme.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private Point initialPosition;

    @BeforeEach
    void setUp() {
        this.initialPosition = new Point(0.0, 0.0);
    }

    @Test
    void createRobotWithValidPosition() {
        Robot robot = new Robot(this.initialPosition);
        assertEquals(this.initialPosition, robot.getActualPosition());
        assertEquals(new Direction(0, 0), robot.getDirection());
        assertEquals(0.0, robot.getSpeed());
        assertFalse(robot.isStopped());
    }

    @Test
    void createRobotWithNullPosition() {
        assertThrows(NullPointerException.class, () -> new Robot(null));
    }

    @Test
    void moveRobotWithValidDirectionAndSpeed() {
        Robot robot = new Robot(this.initialPosition);
        Direction direction = new Direction(1, 1);
        double speed = 5.0;
        robot.move(direction, speed);
        assertEquals(direction, robot.getDirection());
        assertEquals(speed, robot.getSpeed());
        assertEquals(new Point(5.0, 5.0), robot.getActualPosition());
    }

    @Test
    void moveRobotWithInvalidSpeed() {
        Robot robot = new Robot(this.initialPosition);
        Direction direction = new Direction(1, 1);
        assertThrows(IllegalArgumentException.class, () -> robot.move(direction, 0));
    }

    @Test
    void moveRobotWithNullDirection() {
        Robot robot = new Robot(this.initialPosition);
        assertThrows(NullPointerException.class, () -> robot.move(null, 5.0));
    }

    @Test
    void moveRobotInCurrentDirectionAndSpeed() {
        Robot robot = new Robot(this.initialPosition);
        Direction direction = new Direction(1, 1);
        double speed = 5.0;
        robot.move(direction, speed);
        robot.move();
        assertEquals(direction, robot.getDirection());
        assertEquals(speed, robot.getSpeed());
        assertEquals(new Point(10.0, 10.0), robot.getActualPosition());
    }

    @Test
    void addSignalToRobot() {
        Robot robot = new Robot(this.initialPosition);
        Signal signal = new Signal("SIGNAL");
        robot.addSignal(signal);
        assertTrue(robot.containSignal(signal));
    }

    @Test
    void addExistingSignalToRobot() {
        Robot robot = new Robot(this.initialPosition);
        Signal signal = new Signal("SIGNAL");
        robot.addSignal(signal);
        assertThrows(IllegalArgumentException.class, () -> robot.addSignal(signal));
    }

    @Test
    void removeSignalFromRobot() {
        Robot robot = new Robot(this.initialPosition);
        Signal signal = new Signal("SIGNAL");
        robot.addSignal(signal);
        robot.removeSignal(signal);
        assertFalse(robot.containSignal(signal));
    }

    @Test
    void removeNonExistingSignalFromRobot() {
        Robot robot = new Robot(this.initialPosition);
        Signal signal = new Signal("SIGNAL");
        assertThrows(IllegalArgumentException.class, () -> robot.removeSignal(signal));
    }

    @Test
    void stopRobot() {
        Robot robot = new Robot(this.initialPosition);
        robot.move(new Direction(1, 1), 5.0);
        robot.stop();
        assertEquals(new Direction(0, 0), robot.getDirection());
        assertEquals(0.0, robot.getSpeed());
        assertTrue(robot.isStopped());
    }

    @Test
    void toStringTest() {
        Robot robot = new Robot(this.initialPosition);
        Direction direction = new Direction(1, 1);
        double speed = 5.0;
        Signal signal = new Signal("SIGNAL");
        robot.move(direction, speed);
        robot.addSignal(signal);
        String expected = "Robot {actualPosition=Point [x=5.0, y=5.0], direction=Direction [x=1.0, y=1.0], speed=5.0," +
                " signals=[Signal [label=SIGNAL]], isStopped=false}";
        assertEquals(expected, robot.toString());
    }
}
