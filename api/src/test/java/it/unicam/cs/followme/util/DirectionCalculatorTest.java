package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Direction;
import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionCalculatorTest {

    @Test
    void testCalculateDirection1() {
        Point actualPosition = new Point(0, 0);
        Point targetPosition = new Point(3, 4);
        Direction direction = DirectionCalculator.calculateDirection(actualPosition, targetPosition);
        assertEquals(0.6, direction.x(), 0.1);
        assertEquals(0.8, direction.y(), 0.1);
    }

    @Test
    void testCalculateDirection2() {
        Point actualPosition = new Point(2, 2);
        Point targetPosition = new Point(-3, -1);
        Direction direction = DirectionCalculator.calculateDirection(actualPosition, targetPosition);
        assertEquals(-0.8, direction.x(), 0.1);
        assertEquals(-0.5, direction.y(), 0.1);
    }

    @Test
    void testCalculateDirection3() {
        Point actualPosition = new Point(-2, -2);
        Point targetPosition = new Point(5, 1);
        Direction direction = DirectionCalculator.calculateDirection(actualPosition, targetPosition);
        assertEquals(0.9, direction.x(), 0.1);
        assertEquals(0.4, direction.y(), 0.1);
    }

    @Test
    void testCalculateDirection4() {
        Point actualPosition = new Point(5, 5);
        Point targetPosition = new Point(5, 5);
        Direction direction = DirectionCalculator.calculateDirection(actualPosition, targetPosition);
        assertEquals(0, direction.x(), 0.1);
        assertEquals(0, direction.y(), 0.1);
    }

    @Test
    void testCalculateDirectionWithNullPoints() {
        assertThrows(NullPointerException.class, () -> DirectionCalculator
                .calculateDirection(null, new Point(3, 4)));
        assertThrows(NullPointerException.class, () -> DirectionCalculator
                .calculateDirection(new Point(0, 0), null));
        assertThrows(NullPointerException.class, () -> DirectionCalculator
                .calculateDirection(null, null));
    }
}
