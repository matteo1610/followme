package it.unicam.cs.followme.model;

/**
 * An interface representing a shape in space.
 */
public interface Shape {

    /**
     * Retrieves the center point of the shape.
     *
     * @return The center point of the shape.
     */
    Point getCenter();

    /**
     * Determines whether the given point is inside the shape.
     *
     * @param p The point to check for inclusion.
     * @return {@code true} if the point is inside the shape, otherwise {@code false}.
     * @throws NullPointerException If the input point is null.
     */
    boolean containsPosition(Point p);
}
