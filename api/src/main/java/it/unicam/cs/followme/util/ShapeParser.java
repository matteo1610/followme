package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.*;
import it.unicam.cs.followme.utilities.ShapeData;

import java.util.*;

/**
 * A utility class for parsing a list of {@link ShapeData} into {@link Shape} instances.
 */
public final class ShapeParser {

    private static Map<String, Shape> shapes = new HashMap<>();

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private ShapeParser() {}

    /**
     * Parses a list of {@link ShapeData} into {@link Shape} instances and returns a map of parsed shapes.
     *
     * @param shapeDataList The list of {@link ShapeData} data to parse.
     * @return A map of parsed shapes, where the keys are shape labels and the values are {@link Shape} instances.
     */
    public static Map<String, Shape> parseToShape(List<ShapeData> shapeDataList) {
        shapeDataList.forEach(shapeData -> addShape(shapeData));
        return shapes;
    }

    /**
     * Adds a {@link Shape} instance to the map of parsed shapes based on the provided {@link ShapeData}.
     *
     * @param shape The {@link ShapeData} instance representing the shape to add.
     * @throws IllegalArgumentException if the provided {@link ShapeData} is invalid or unsupported.
     */
    private static void addShape(ShapeData shape) {
        double[] args = shape.args();
        switch (ShapeType.valueOf(shape.shape())) {
            case CIRCLE    -> shapes
                    .put(shape.label(), new Circle(new Point(args[0], args[1]), args[2]));
            case RECTANGLE -> shapes
                    .put(shape.label(), new Rectangle(new Point(args[0], args[1]), args[2], args[3]));
            default -> throw new IllegalArgumentException("Unsupported shape: " + shape.shape());
        }
    }
}
