package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPointGeneratorTest {

    @Test
    void testGeneratePointBetweenTwoPoints() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 5);
        Point randomPoint = RandomPointGenerator.generatePoint(p1, p2);
        assertTrue(randomPoint.x() >= p1.x() && randomPoint.x() <= p2.x());
        assertTrue(randomPoint.y() >= p1.y() && randomPoint.y() <= p2.y());
    }

    @Test
    void testGeneratePointWithinRange() {
        double minX = 10;
        double maxX = 20;
        double minY = 30;
        double maxY = 40;
        Point randomPoint = RandomPointGenerator.generatePoint(minX, maxX, minY, maxY);
        assertTrue(randomPoint.x() >= minX && randomPoint.x() <= maxX);
        assertTrue(randomPoint.y() >= minY && randomPoint.y() <= maxY);
    }

    @Test
    void testGeneratePointWithNullInputs() {
        assertThrows(NullPointerException.class, () -> RandomPointGenerator.generatePoint(null, new Point(4, 5)));
        assertThrows(NullPointerException.class, () -> RandomPointGenerator.generatePoint(new Point(1, 2), null));
        assertThrows(NullPointerException.class, () -> RandomPointGenerator.generatePoint(null, null));
    }
}