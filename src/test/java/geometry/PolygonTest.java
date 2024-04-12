package geometry;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class PolygonTest {

    @Test
    public void testCalculateMidpoints() {
        // Create a test polygon with vertices
        Coord[] vertices = {
                new Coord(2, 4),
                new Coord(5, 8),
                new Coord(-3, 6),
                new Coord(0, -2),
                new Coord(7, 3)
        };
        Polygon polygon = new Polygon(vertices);
        ArrayList<Coord> midpoints = polygon.getMidpoints();

        // Define the expected midpoints
        Coord[] expectedMidpoints = {
                new Coord(3.5, 6),
                new Coord(1, 7),
                new Coord(-1.5, 2),
                new Coord(3.5, 0.5),
                new Coord(4.5, 3.5)
        };
        // Assert that the size of the midpoints list is correct
        assertEquals(expectedMidpoints.length, midpoints.size(), "Size mismatch");
        // Assert each midpoint individually
        for (int i = 0; i < expectedMidpoints.length; i++) {
            Coord expected = expectedMidpoints[i];
            Coord actual = midpoints.get(i);
            // Assert x-coordinate
            assertEquals(expected.getX(), actual.getX(), 0.001, "X-coordinate mismatch at index " + i);
            // Assert y-coordinate
            assertEquals(expected.getY(), actual.getY(), 0.001, "Y-coordinate mismatch at index " + i);
        }
    }

    @Test
    public void testCalculateLinePoints() {
        // Create test polygon
        Coord[] verticies = {
                new Coord(0,0),
                new Coord(1,0),
                new Coord(0,1)
        };
        Polygon triangle = new Polygon(verticies);
        ArrayList<Coord> points = triangle.getPoints();

        // Define expected points
        Coord[] expectedPoints = {
                new Coord(0.1, 0),
                new Coord(0.2, 0),
                new Coord(0.3, 0),
                new Coord(0.4, 0),
                new Coord(0.5, 0),
                new Coord(0.6, 0),
                new Coord(0.7, 0),
                new Coord(0.8, 0),
                new Coord(0.9, 0),
                new Coord(0.9, 0.1),
                new Coord(0.8, 0.2),
                new Coord(0.7, 0.3),
                new Coord(0.6, 0.4),
                new Coord(0.5, 0.5),
                new Coord(0.4, 0.6),
                new Coord(0.3, 0.7),
                new Coord(0.2, 0.8),
                new Coord(0.1, 0.9),
                new Coord(0, 0.9),
                new Coord(0, 0.8),
                new Coord(0, 0.7),
                new Coord(0, 0.6),
                new Coord(0, 0.5),
                new Coord(0, 0.4),
                new Coord(0, 0.3),
                new Coord(0, 0.2),
                new Coord(0, 0.1)
        };
        // Assert that the size of the midpoints list is correct
        assertEquals(expectedPoints.length, points.size(), "Size mismatch");
        // Assert each midpoint individually
        for (int i = 0; i < expectedPoints.length; i++) {
            Coord expected = expectedPoints[i];
            Coord actual = points.get(i);
            // Assert x-coordinate
            assertEquals(expected.getX(), actual.getX(), 0.001, "X-coordinate mismatch at index " + i);
            // Assert y-coordinate
            assertEquals(expected.getY(), actual.getY(), 0.001, "Y-coordinate mismatch at index " + i);
        }

    }
}
