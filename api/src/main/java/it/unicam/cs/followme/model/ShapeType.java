package it.unicam.cs.followme.model;

/**
 * An enum representing different types of shapes.
 */
public enum ShapeType {

    CIRCLE("CIRCLE"),
    RECTANGLE("RECTANGLE");

    private final String code;

    /**
     * Creates a new ShapeType enum value with the specified code.
     *
     * @param code The code representing the shape type.
     */
    ShapeType(String code) {
        this.code = code;
    }
}
