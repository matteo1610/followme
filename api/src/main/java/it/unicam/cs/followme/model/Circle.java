package it.unicam.cs.followme.model;

import it.unicam.cs.followme.util.DistanceCalculator;

import java.util.Objects;

/**
 * A class representing the circle shape.
 */
public final class Circle extends GeometricShape {

    private final double radius;

    /**
     * Creates a new Circle instance with the specified center point and radius.
     *
     * @param center The center point of the circle.
     * @param radius The radius of the circle.
     * @throws NullPointerException If the provided center is null.
     */
    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    /**
     * Retrieves the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public boolean containsPosition(Point p) {
        if (p == null)
            throw new NullPointerException("The point parameter cannot be null.");
        return DistanceCalculator.calculateDistance(this.getCenter(), p) <= this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return this.getCenter().equals(((Circle) o).getCenter()) && Double.compare(this.radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCenter(), this.radius);
    }

    @Override
    public String toString() {
        return "Circle [center=" + this.getCenter() + ", radius=" + this.radius + "]";
    }
}
