package it.unicam.cs.followme.util;

import it.unicam.cs.followme.model.Circle;
import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Rectangle;
import it.unicam.cs.followme.model.Shape;
import it.unicam.cs.followme.utilities.ShapeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShapeParserTest {

    @Test
    void testParseToShape() {
        List<ShapeData> shapeDataList = new ArrayList<>();
        shapeDataList.add(new ShapeData("LBL-CIRCLE1", "CIRCLE", new double[]{2, 3, 5}));
        shapeDataList.add(new ShapeData("LBL-RECTANGLE1", "RECTANGLE", new double[]{1, 1, 4, 3}));
        Map<String, Shape> shapes = ShapeParser.parseToShape(shapeDataList);
        assertEquals(shapes.get("LBL-CIRCLE1"), new Circle(new Point(2, 3), 5));
        assertEquals(shapes.get("LBL-RECTANGLE1"), new Rectangle(new Point(1, 1), 4, 3));
    }

    @Test
    void testInvalidShapeType() {
        List<ShapeData> shapeDataList = new ArrayList<>();
        shapeDataList.add(new ShapeData("INVALID-SHAPE", "DOG", new double[]{2, 3, 5}));
        assertThrows(IllegalArgumentException.class, () -> ShapeParser.parseToShape(shapeDataList));
    }
}
