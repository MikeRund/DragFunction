package util;

import geometry.Coord;
import geometry.Polygon;
import model.PointData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometryUtilTest {

    @Test
    public void calculateDistanceTest() {
        // Create test cases for calculateDistance method
        Coord coordA1 = new Coord(3, 4);
        Coord coordB1 = new Coord(0,0);
        Coord coordA2 = new Coord(-1,-1);
        Coord coordB2 = new Coord(2,3);
        // Define expected and calculated value
        double expectedDistance = 5.0;
        double calculatedDistance1 = GeometryUtil.calculateDistance(coordA1, coordB1);
        double calculatedDistance2 = GeometryUtil.calculateDistance(coordA2, coordB2);
        // Assert distances
        assertEquals(expectedDistance, calculatedDistance1, "Size do not match");
        assertEquals(expectedDistance, calculatedDistance2, "Size do not match");
    }
    @Test
    public void calculateClosestVertexTest() {
        // Test cases for calculateClosestVertex method
        Coord[] verticesA1 = {
                new Coord(0, 0),
                new Coord(0, 5),
                new Coord(5, 5),
                new Coord(5, 0),
        };
        Coord[] verticesB1 = {
                new Coord(0, 0),
                new Coord(2, 6),
                new Coord(6, 6),
                new Coord(6, 2),
        };
        Coord[] verticesA2 = {
                new Coord(-3, -3),
                new Coord(-3, 3),
                new Coord(3, 3),
                new Coord(3, -3),
        };
        Coord[] verticesB2 = {
                new Coord(2, 2),
                new Coord(2, 6),
                new Coord(6, 6),
                new Coord(6, 2),
        };
        Polygon shapeA1 = new Polygon(verticesA1);
        Polygon shapeB1 = new Polygon(verticesB1);
        Polygon shapeA2 = new Polygon(verticesA2);
        Polygon shapeB2 = new Polygon(verticesB2);

        // Define expected and calculated values
        PointData expected1 = new PointData(new Coord(0, 0), new Coord(0, 0), 0);
        PointData expected2 = new PointData(new Coord(3, 3), new Coord(2, 2), Math.sqrt(2));
        PointData actual1 = GeometryUtil.calculateClosestVertex(shapeA1, shapeB1);
        PointData actual2 = GeometryUtil.calculateClosestVertex(shapeA2, shapeB2);

        // Assert expected and actual
        assertEquals(expected1.getDistance(), actual1.getDistance(), 0.005, "Vertex distance fail: Case 1");
        System.out.println("Expected1: " + expected1 +  ", Actual1: " + actual1);
        assertEquals(expected2.getDistance(), actual2.getDistance(), 0.005, "Vertex distance fail: Case 2");
        System.out.println("Expected2: " + expected2 +  ", Actual2: " + actual2);
    }

    @Test
    public void testCalculateClosestMidpoint() {
        // Test cases for calculateClosestMidpoint method
        Coord[] verticesA1 = {
                new Coord(0, 0),
                new Coord(0, 4),
                new Coord(4, 4),
                new Coord(4, 0),
        };
        Coord[] verticesB = {
                new Coord(1, 1),
                new Coord(1, 5),
                new Coord(5, 5),
                new Coord(5, 1),
        };
        Coord[] verticesA2 = {
                new Coord(-2, -2),
                new Coord(-2, 2),
                new Coord(2, 2),
                new Coord(2, -2),
        };
        Polygon shapeA1 = new Polygon(verticesA1);
        Polygon shapeB = new Polygon(verticesB);
        Polygon shapeA2 = new Polygon(verticesA2);

        // Define expected and calculated values
        PointData expected1 = new PointData(new Coord(2, 4), new Coord(1, 5), Math.sqrt(2));
        PointData expected2 = new PointData(new Coord(0, 2), new Coord(1, 1), Math.sqrt(2));
        PointData actual1 = GeometryUtil.calculateClosestMidpoint(shapeA1, shapeB);
        PointData actual2 = GeometryUtil.calculateClosestMidpoint(shapeA2, shapeB);

        // Assert expected and calculated
        assertEquals(expected1.getDistance(), actual1.getDistance(), 0.005, "Midpoint distance fail: Case 1");
        System.out.println("Expected1: " + expected1 +  ", Actual1: " + actual1);
        assertEquals(expected2.getDistance(), actual2.getDistance(), 0.005, "Midpoint distance fail: Case 2");
        System.out.println("Expected2: " + expected2 +  ", Actual2: " + actual2);
    }

    @Test
    public void testCalculateClosestPoint() {
        // Test cases for calculateClosestPoint method
        Coord[] verticesA = {
                new Coord(0,0),
                new Coord(1,0),
                new Coord(0,1)
        };
        Coord[] verticesB1 = {
                new Coord(0.1,0),
                new Coord(2,3),
                new Coord(3,5)
        };
        Coord[] verticesB2 = {
                new Coord(1.1,1.9),
                new Coord(2.1,3.9),
                new Coord(3.1,5.9)
        };
        Polygon shapeA = new Polygon(verticesA);
        Polygon shapeB1 = new Polygon(verticesB1);
        Polygon shapeB2 = new Polygon(verticesB2);

        // Define expected and calculated values
        PointData expected1 = new PointData(new Coord(0.1, 0), new Coord(0.1, 0), 0);
        PointData expected2 = new PointData(new Coord(0.1, 0.9), new Coord(1.1, (1.9)), Math.sqrt(2));
        PointData actual1 = GeometryUtil.calculateClosestPoint(shapeA, shapeB1);
        PointData actual2 = GeometryUtil.calculateClosestPoint(shapeA, shapeB2);

        // Assert expected closest distance with calculated closest distance
        assertEquals(expected1.getDistance(), actual1.getDistance(), 0.005, "Point distance fail: Case 1");
        System.out.println("Expected1: " + expected1 +  ", Actual1: " + actual1);
        assertEquals(expected2.getDistance(), actual2.getDistance(), 0.005, "Point distance fail: Case 2");
        System.out.println("Expected2: " + expected2 +  ", Actual2: " + actual2);
    }

//        double expectedDistance2 = Math.sqrt(2);
//        double calculatedDistance1 = GeometryUtil.calculateClosestPoint(shapeA, shapeB1);
//        double calculatedDistance2 = GeometryUtil.calculateClosestPoint(shapeA, shapeB2);
//        // Assert expected closest distance with calculated closest distance
//        assertEquals(expectedDistance1, calculatedDistance1, 0.005, "Point distance fail: Case 1");
//        assertEquals(expectedDistance2, calculatedDistance2, 0.005, "Point distance fail: Case 2");


    @Test
    public void testCalculateSnapped() {
        // Shared verticesB test case
        Coord[] verticesB = {
                new Coord(2,3),
                new Coord(4,5),
                new Coord(6,7),
                new Coord(8,9)
        };
        // Test cases
        // Test case to test negative change
        Coord start1 = new Coord(2,3);
        Coord snapped1 = new Coord(1,2);
        // Test case to test positive change
        Coord start2 = new Coord(2,3);
        Coord snapped2 = new Coord(3,4);
        // Test case to test no change
        Coord start3 = new Coord(2,3);
        Coord snapped3 = new Coord(2,3);

        // Define expected and calculated values
        // Test case to test negative change
        Coord[] expected1 = {
                new Coord(1,2),
                new Coord(3,4),
                new Coord(5,6),
                new Coord(7,8)
        };
        Coord[] actual1 = GeometryUtil.calculateSnapped(start1, snapped1, verticesB);
        // Test case to test positive change
        Coord[] expected2 = {
                new Coord(3,4),
                new Coord(5,6),
                new Coord(7,8),
                new Coord(9,10)
        };
        Coord[] actual2 = GeometryUtil.calculateSnapped(start2, snapped2, verticesB);
        // Test case to test no change
        Coord[] expected3 = verticesB;
        Coord[] actual3 = GeometryUtil.calculateSnapped(start3, snapped3, verticesB);

        // Assert actual and expected
        // Test case 1
        for (int i = 0; i < expected1.length; i++){
            assertEquals(expected1[i].getX(), actual1[i].getX(), "Snapped x value fail: Case 1 iteration " + i);
            assertEquals(expected1[i].getY(), actual1[i].getY(), "Snapped y value fail: Case 1 iteration " + i);
        }
        // Test case 2
        for (int i = 0; i < expected1.length; i++){
            assertEquals(expected2[i].getX(), actual2[i].getX(), "Snapped x value fail: Case 2 iteration " + i);
            assertEquals(expected2[i].getY(), actual2[i].getY(), "Snapped y value fail: Case 2 iteration " + i);
        }
        // Test case 3
        for (int i = 0; i < expected1.length; i++){
            assertEquals(expected3[i].getX(), actual3[i].getX(), "Snapped x value fail: Case 3 iteration " + i);
            assertEquals(expected3[i].getY(), actual3[i].getY(), "Snapped y value fail: Case 3 iteration " + i);
        }
    }
}
