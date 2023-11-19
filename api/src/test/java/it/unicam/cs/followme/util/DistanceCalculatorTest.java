package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    void testDeltaX() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 2);
        double result = DistanceCalculator.deltaX(p1, p2);
        assertEquals(3, result, 0.1);
    }

    @Test
    void testDeltaXWithNullPoints() {
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaX(null, new Point(3, 4)));
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaX(new Point(0, 0), null));
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaX(null, null));
    }

    @Test
    void testDeltaY() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 5);
        double result = DistanceCalculator.deltaY(p1, p2);
        assertEquals(3, result, 0.1);
    }

    @Test
    void testDeltaYWithNullPoints() {
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaY(null, new Point(3, 4)));
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaY(new Point(0, 0), null));
        assertThrows(NullPointerException.class, () -> DistanceCalculator.deltaY(null, null));
    }

    @Test
    void testCalculateDistance1() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);
        double result = DistanceCalculator.calculateDistance(p1, p2);
        assertEquals(5, result, 0.1);
    }

    @Test
    void testCalculateDistance2() {
        Point p1 = new Point(10, 48);
        Point p2 = new Point(1, 4);
        double result = DistanceCalculator.calculateDistance(p1, p2);
        assertEquals(45, result, 0.1);
    }

    @Test
    void testCalculateDistanceWithNullPoints() {
        assertThrows(NullPointerException.class, () -> DistanceCalculator
                .calculateDistance(null, new Point(3, 4)));
        assertThrows(NullPointerException.class, () -> DistanceCalculator
                .calculateDistance(new Point(0, 0), null));
        assertThrows(NullPointerException.class, () -> DistanceCalculator.calculateDistance(null, null));
    }
}
