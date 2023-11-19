package it.unicam.cs.followme.model;

/**
 * An abstract base class representing a geometric shape with a center point.
 */
public abstract class GeometricShape implements Shape {

    private final Point center;

    /**
     * Constructs a geometric shape with the specified center point.
     *
     * @param center The center point coordinates of the geometric shape.
     * @throws NullPointerException If the provided center is null.
     */
    public GeometricShape(Point center) {
        if (center == null)
            throw new NullPointerException("The center of a shape cannot be null.");
        this.center = center;
    }

    @Override
    public Point getCenter() {
        return this.center;
    }
}
