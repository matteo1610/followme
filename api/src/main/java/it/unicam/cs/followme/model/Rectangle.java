package it.unicam.cs.followme.model;

import it.unicam.cs.followme.util.DistanceCalculator;

import java.util.Objects;

/**
 * A class representing the rectangle shape.
 */
public final class Rectangle extends GeometricShape {

    private final double width;
    private final double height;

    /**
     * Creates a new Rectangle instance with the specified center point, width and height.
     *
     * @param center The center point of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @throws NullPointerException If the provided center is null.
     */
    public Rectangle(Point center, double width, double height) {
        super(center);
        this.width = width;
        this.height = height;
    }

    /**
     * Retrieves the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Retrieves the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    @Override
    public boolean containsPosition(Point p) {
        if (p == null)
            throw new NullPointerException("The point parameter cannot be null.");
        return DistanceCalculator.deltaX(p, this.getCenter()) <= width / 2 &&
                DistanceCalculator.deltaY(p, this.getCenter()) <= height / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return this.getCenter().equals(((Rectangle) o).getCenter()) && Double.compare(width, rectangle.width) == 0 &&
                Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCenter(), this.width, this.height);
    }

    @Override
    public String toString() {
        return "Rectangle [center=" + this.getCenter() + ", width=" + this.width + ", height=" + this.height + "]";
    }
}
