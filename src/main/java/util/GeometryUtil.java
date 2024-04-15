package util;

import geometry.Coord;
import geometry.Polygon;
import model.PointData;

// Class that contains all useful methods for analyzing distances between points in Polygon class
public class GeometryUtil {

    // Method to calculate distance between two points
    public static double calculateDistance(Coord coordA, Coord coordB) {

        // Re-write of the Pythagorean theorem formula to calculate the distance between 2 points
        double deltaX = coordB.getX() - coordA.getX();
        double deltaY = coordB.getY() - coordA.getY();
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }

    // Method to calculate the closest vertices between 2 Polygon objects
    public static PointData calculateClosestVertex(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minVertexA = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minVertexB = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        // Check distance of every vertex of A with every vertex of B
        for (Coord vertexA : shapeA.getvertices()) {
            for (Coord vertexB : shapeB.getvertices()) {
                distance = calculateDistance(vertexA, vertexB);

                if (distance < minDist) {

                    // Store the 2 vertices and the distance between them
                    minDist = distance;
                    minVertexA = vertexA;
                    minVertexB = vertexB;
                }
            }
        }
        // Use points and distance to create new PointData object
        return new PointData(minVertexA, minVertexB, minDist);
    }

    // Method to calculate the closest midpoint of A to any vertex of B
    public static PointData calculateClosestMidpoint(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minMidpoint= new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minVertexB = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        // Check distance of every midpoint of A with every vertex of B
        for (Coord mid : shapeA.getMidpoints()) {
            for (Coord vertex : shapeB.getvertices()) {
                distance = calculateDistance(mid, vertex);

                // Store the midpoint of A and vertex of B, and the distance between them
                if (distance < minDist) {
                    minDist = distance;
                    minMidpoint = mid;
                    minVertexB = vertex;
                }
            }
        }
        // Use points and distance to create new PointData object
        return new PointData(minMidpoint, minVertexB, minDist);
    }

    // Method to calculate the closest point of A to any vertex of B
    public static PointData calculateClosestPoint(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minVertex = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minPoint = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        // Check distance of every point of A with every vertex of B
        for (Coord point : shapeA.getPoints()) {
            for (Coord vertex : shapeB.getvertices()) {
                distance = calculateDistance(point, vertex);
                if (distance < minDist) {
                    minDist = distance;
                    minVertex = vertex;
                    minPoint = point;
                }
            }
        }
        // Use points and distance to create new PointData object
        return new PointData(minPoint, minVertex, minDist);
    }

    // Method to calculate the new vertices of B after snapping
    public static Coord[] calculateSnapped(Coord start, Coord snapped, Coord[] verticesB) {

        // Calculate change in x and y-axis
        double deltaX = snapped.getX() - start.getX();
        double deltaY = snapped.getY() - start.getY();
        Coord[] verticesBSnapped = new Coord[verticesB.length];

        // Add new co-ord after each change in x & y-axis
        for (int i = 0; i < verticesBSnapped.length; i++) {
            double x = verticesB[i].getX() + deltaX;
            double y = verticesB[i].getY() + deltaY;
            verticesBSnapped[i] = new Coord(x, y);
        }
        return verticesBSnapped;
    }
}
