package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Point;

import java.util.Random;

/**
 * A utility class for generating random points in a specified range or between two given points.
 */
public final class RandomPointGenerator {

    private static Random random = new Random();

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private RandomPointGenerator() {}

    /**
     * Generates a random point between two specified points.
     *
     * @param p1 The first point defining the range.
     * @param p2 The second point defining the range.
     * @return A randomly generated {@link Point} within the specified range.
     * @throws NullPointerException if either of the input points is null.
     */
    public static Point generatePoint(Point p1, Point p2) {
        if (p1 == null || p2 == null)
            throw new NullPointerException("Attempt to generate point with the required points missing");
        return new Point(p1.x() + (p2.x() - p1.x()) * random.nextDouble(),
                p1.y() + (p2.y() - p1.y()) * random.nextDouble());
    }

    /**
     * Generates a random point within a specified range.
     *
     * @param minX The minimum x-coordinate of the range.
     * @param maxX The maximum x-coordinate of the range.
     * @param minY The minimum y-coordinate of the range.
     * @param maxY The maximum y-coordinate of the range.
     * @return A randomly generated {@link Point} within the specified range.
     */
    public static Point generatePoint(double minX, double maxX, double minY, double maxY) {
        return new Point(minX + (maxX - minX) * random.nextDouble(), minY + (maxY - minY) * random.nextDouble());
    }
}
