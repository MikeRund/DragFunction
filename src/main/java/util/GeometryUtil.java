package util;

import geometry.Coord;
import geometry.Polygon;
import model.PointData;

public class GeometryUtil {

    public static double calculateDistance(Coord coordA, Coord coordB) {
        double deltaX = coordB.getX() - coordA.getX();
        double deltaY = coordB.getY() - coordA.getY();
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }
    public static PointData calculateClosestVertex(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minVertexA = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minVertexB = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        for (Coord vertexA : shapeA.getvertices()) {
            for (Coord vertexB : shapeB.getvertices()) {
                distance = calculateDistance(vertexA, vertexB);
                System.out.println(vertexA + " dist from" + vertexB + " = " + distance);
                if (distance < minDist) {
                    minDist = distance;
                    minVertexA = vertexA;
                    minVertexB = vertexB;
                }
            }
        }
        return new PointData(minVertexA, minVertexB, minDist);
    }

    public static PointData calculateClosestMidpoint(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minMidpoint= new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minVertexB = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        for (Coord mid : shapeA.getMidpoints()) {
            for (Coord vertex : shapeB.getvertices()) {
                distance = calculateDistance(mid, vertex);
                System.out.println(mid + " dist from " + vertex + " = " + distance);
                if (distance < minDist) {
                    minDist = distance;
                    minMidpoint = mid;
                    minVertexB = vertex;
                }
            }
        }
        return new PointData(minMidpoint, minVertexB, minDist);
    }

    public static PointData calculateClosestPoint(Polygon shapeA, Polygon shapeB) {
        double distance;
        double minDist = Double.MAX_VALUE;
        Coord minVertex = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);
        Coord minPoint = new Coord(Double.MAX_VALUE, Double.MAX_VALUE);

        for (Coord point : shapeA.getPoints()) {
            for (Coord vertex : shapeB.getvertices()) {
                distance = calculateDistance(point, vertex);
                System.out.println(point + " dist from" + vertex + " = " + distance);
                if (distance < minDist) {
                    minDist = distance;
                    minVertex = vertex;
                    minPoint = point;
                }
            }
        }
//        System.out.println("Vertex: " + minVertex + ", Point: " + minPoint + ", Distance: " + minDist);
        return new PointData(minPoint, minVertex, minDist);
    }
    // Method to calculate the new vertices of B after snapping
    public static Coord[] calculateSnapped(Coord start, Coord snapped, Coord[] verticesB) {
        // Calculate change in x and y-axis
        double deltaX = snapped.getX() - start.getX();
        double deltaY = snapped.getY() - start.getY();
        System.out.println("Change in x: " + deltaX + ", Change in y: " + deltaY);
        Coord[] verticesBSnapped = new Coord[verticesB.length];

        // Add new co-ord after each change in x & y-axis
        for (int i = 0; i < verticesBSnapped.length; i++) {
            double x = verticesB[i].getX() + deltaX;
            double y = verticesB[i].getY() + deltaY;
            System.out.print(verticesB[i] + " snaps to: ");
            verticesBSnapped[i] = new Coord(x, y);
            System.out.println(verticesBSnapped[i]);
        }
        return verticesBSnapped;
    }
}
