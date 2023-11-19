package it.unicam.cs.followme.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void createCircleWithValidValues() {
        Point center = new Point(2.0, 3.0);
        double radius = 5.0;
        Circle circle = new Circle(center, radius);
        assertEquals(center, circle.getCenter());
        assertEquals(radius, circle.getRadius());
    }

    @Test
    void createCircleWithNullCenter() {
        assertThrows(NullPointerException.class, () -> new Circle(null, 5.0));
    }

    @Test
    void containsPositionInsideCircle() {
        Point center = new Point(0.0, 0.0);
        double radius = 10.0;
        Circle circle = new Circle(center, radius);
        Point insidePoint = new Point(5.0, 5.0);
        assertTrue(circle.containsPosition(insidePoint));
    }

    @Test
    void containsPositionOnCircleBoundary() {
        Point center = new Point(0.0, 0.0);
        double radius = 10.0;
        Circle circle = new Circle(center, radius);
        Point boundaryPoint = new Point(10.0, 0.0);
        assertTrue(circle.containsPosition(boundaryPoint));
    }

    @Test
    void containsPositionOutsideCircle() {
        Point center = new Point(0.0, 0.0);
        double radius = 10.0;
        Circle circle = new Circle(center, radius);
        Point outsidePoint = new Point(15.0, 0.0);
        assertFalse(circle.containsPosition(outsidePoint));
    }

    @Test
    void containsPositionWithNullPoint() {
        Point center = new Point(0.0, 0.0);
        double radius = 10.0;
        Circle circle = new Circle(center, radius);
        assertThrows(NullPointerException.class, () -> circle.containsPosition(null));
    }

    @Test
    void toStringTest() {
        Point center = new Point(2.0, 3.0);
        double radius = 5.0;
        Circle circle = new Circle(center, radius);
        assertEquals("Circle [center=Point [x=2.0, y=3.0], radius=5.0]", circle.toString());
    }
}
