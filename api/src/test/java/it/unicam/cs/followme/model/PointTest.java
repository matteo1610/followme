package it.unicam.cs.followme.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void createPointWithValidCoordinates() {
        Point point = new Point(3.0, -2.5);
        assertEquals(3.0, point.x());
        assertEquals(-2.5, point.y());
    }

    @Test
    void toStringTest() {
        Point point = new Point(1.5, 2.0);
        assertEquals("Point [x=1.5, y=2.0]", point.toString());
    }
}
