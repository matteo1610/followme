package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Direction;
import it.unicam.cs.followme.model.Point;

/**
 * A utility class for calculating directions based on positions.
 */
public final class DirectionCalculator {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private DirectionCalculator() {
    }

    /**
     * Calculates the direction vector from the actual position to the target position.
     *
     * @param actualPosition The starting point of the calculation.
     * @param targetPosition The target point.
     * @return A {@link Direction} instance representing the calculated direction vector.
     * @throws NullPointerException If either the actualPosition or targetPosition is null.
     */
    public static Direction calculateDirection(Point actualPosition, Point targetPosition) {
        if (actualPosition == null || targetPosition == null)
            throw new NullPointerException("Attempt to calculate direction with the required points missing");
        double deltaX = targetPosition.x() - actualPosition.x();
        double deltaY = targetPosition.y() - actualPosition.y();
        if (deltaX == 0 && deltaY == 0) {
            return new Direction(0, 0);
        }
        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return new Direction(deltaX / magnitude, deltaY / magnitude);
    }
}
