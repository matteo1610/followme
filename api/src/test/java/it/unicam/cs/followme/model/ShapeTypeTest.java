package it.unicam.cs.followme.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTypeTest {

    @Test
    void testEnumValues() {
        ShapeType circle = ShapeType.CIRCLE;
        ShapeType rectangle = ShapeType.RECTANGLE;
        assertNotNull(circle);
        assertNotNull(rectangle);
    }

    @Test
    void testEnumCode() {
        ShapeType circle = ShapeType.CIRCLE;
        ShapeType rectangle = ShapeType.RECTANGLE;
        assertEquals("CIRCLE", circle.toString());
        assertEquals("RECTANGLE", rectangle.toString());
    }
}
