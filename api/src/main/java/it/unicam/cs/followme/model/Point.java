package it.unicam.cs.followme.model;

/**
 * A simple record representing a point in a two-dimensional space.
 * @param x The x-coordinate of the point.
 * @param y The y-coordinate of the point.
 */
public record Point(double x, double y) {

    @Override
    public String toString() {
        return "Point [x=" + this.x + ", y=" + this.y + "]";
    }
}
