package it.unicam.cs.followme.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void createDirectionWithValidComponents1() {
        Direction direction = new Direction(0.5, -0.3);
        assertEquals(0.5, direction.x());
        assertEquals(-0.3, direction.y());
    }

    @Test
    void createDirectionWithValidComponents2() {
        Direction direction = new Direction(0, 0);
        assertEquals(0, direction.x());
        assertEquals(0, direction.y());
    }

    @Test
    void createDirectionWithValidComponents3() {
        Direction direction = new Direction(1, -1);
        assertEquals(1, direction.x());
        assertEquals(-1, direction.y());
    }

    @Test
    void createDirectionWithInvalidComponents() {
        assertThrows(IllegalArgumentException.class, () -> new Direction(1.5, 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Direction(0.0, -1.2));
        assertThrows(IllegalArgumentException.class, () -> new Direction(1.2, -0.8));
    }

    @Test
    void toStringTest() {
        Direction direction = new Direction(0.7, -0.2);
        assertEquals("Direction [x=0.7, y=-0.2]", direction.toString());
    }
}