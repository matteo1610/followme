package it.unicam.cs.followme.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void createRectangleWithValidValues() {
        Point center = new Point(2.0, 3.0);
        double width = 10.0;
        double height = 6.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        assertEquals(center, rectangle.getCenter());
        assertEquals(width, rectangle.getWidth());
        assertEquals(height, rectangle.getHeight());
    }

    @Test
    void createRectangleWithNullCenter() {
        assertThrows(NullPointerException.class, () -> new Rectangle(null, 10.0, 6.0));
    }

    @Test
    void containsPositionInsideRectangle() {
        Point center = new Point(0.0, 0.0);
        double width = 8.0;
        double height = 4.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        Point insidePoint = new Point(3.0, 2.0);
        assertTrue(rectangle.containsPosition(insidePoint));
    }

    @Test
    void containsPositionOnRectangleBoundary() {
        Point center = new Point(0.0, 0.0);
        double width = 8.0;
        double height = 4.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        Point boundaryPoint = new Point(4.0, 2.0);
        assertTrue(rectangle.containsPosition(boundaryPoint));
    }

    @Test
    void containsPositionOutsideRectangle() {
        Point center = new Point(0.0, 0.0);
        double width = 8.0;
        double height = 4.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        Point outsidePoint = new Point(6.0, 3.0);
        assertFalse(rectangle.containsPosition(outsidePoint));
    }

    @Test
    void containsPositionWithNullPoint() {
        Point center = new Point(0.0, 0.0);
        double width = 8.0;
        double height = 4.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        assertThrows(NullPointerException.class, () -> rectangle.containsPosition(null));
    }

    @Test
    void toStringTest() {
        Point center = new Point(2.0, 3.0);
        double width = 10.0;
        double height = 6.0;
        Rectangle rectangle = new Rectangle(center, width, height);
        assertEquals("Rectangle [center=Point [x=2.0, y=3.0], width=10.0, height=6.0]", rectangle.toString());
    }
}
