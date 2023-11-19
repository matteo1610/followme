package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Point;

/**
 * This utility class provides methods to calculate the distance between two points in a two-dimensional space.
 */
public final class DistanceCalculator {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private DistanceCalculator() {}

    /**
     * Calculates the distance between two points along the x-axis.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @return The distance along the x-axis between the two points.
     * @throws NullPointerException If either p1 or p2 is null.
     */
    public static double deltaX(Point p1, Point p2) {
        if (p1 == null || p2 == null)
            throw new NullPointerException("Attempt to calculate distance with the required points missing");
        return Math.abs(p2.x() - p1.x());
    }

    /**
     * Calculates the distance between two point along the y-axis.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @return The distance along the y-axis between the two points.
     * @throws NullPointerException If either p1 or p2 is null.
     */
    public static double deltaY(Point p1, Point p2) {
        if (p1 == null || p2 == null)
            throw new NullPointerException("Attempt to calculate distance with the required points missing");
        return Math.abs(p2.y() - p1.y());
    }

    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @return The distance between the two points.
     * @throws NullPointerException If either p1 or p2 is null.
     */
    public static double calculateDistance(Point p1, Point p2) {
        if (p1 == null || p2 == null)
            throw new NullPointerException("Attempt to calculate distance with the required points missing");
        return Math.sqrt(Math.pow(p2.x() - p1.x(), 2) + Math.pow(p2.y() - p1.y(), 2));
    }
}
