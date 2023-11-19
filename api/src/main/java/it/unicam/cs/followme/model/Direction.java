package it.unicam.cs.followme.model;

/**
 * A record representing a directional vector for movement.
 *
 * The Direction class is used to indicate the direction of movement in two-dimensional space, where 'x' and 'y'
 * represent the horizontal and vertical components of the vector. The vector's magnitude is limited to be between -1
 * and 1 to be valid.
 */
public record Direction(double x, double y) {

    /**
     * Constructs a Direction with the specified x and y components.
     *
     * @param x The x-component of the directional vector. Must be within the range [-1, 1].
     * @param y The y-component of the directional vector. Must be within the range [-1, 1].
     * @throws IllegalArgumentException If the x or y value is outside the range [-1, 1].
     */
    public Direction {
        if (x < -1 || x > 1 || y < -1 || y > 1)
            throw new IllegalArgumentException("Invalid direction values.");
    }

    @Override
    public String toString() {
        return "Direction [x=" + this.x + ", y=" + this.y + "]";
    }
}
