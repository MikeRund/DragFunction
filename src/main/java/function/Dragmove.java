package function;

import geometry.Coord;
import geometry.Polygon;
import model.PointData;
import model.SnapResult;
import util.GeometryUtil;

public class Dragmove {
    static final double VERTEX_SNAP = 20;
    static final double MIDPOINT_SNAP = 15;
    static final double POINT_SNAP = 10;
    public static SnapResult dragmove(Coord[] verticesA, Coord[] verticesB){
        SnapResult result = new SnapResult(verticesB);
        String snapDetails = "";
        Polygon shapeA = new Polygon(verticesA);
        Polygon shapeB = new Polygon(verticesB);

        if (GeometryUtil.calculateClosestVertex(shapeA, shapeB).getDistance() <= VERTEX_SNAP) {

            // Store snap information in PointData object
            PointData pointData = GeometryUtil.calculateClosestVertex(shapeA, shapeB);
            Coord vertexA = pointData.getPointA(); // Vertex of A that activated the snap
            Coord vertexB = pointData.getPointB(); // Vertex of B that activated the snap
            double snapDistance = pointData.getDistance();

            // Build snap details:
            snapDetails += "Vertex to vertex snap occurred." + "\n";
            snapDetails += "Vertex of B: " + vertexB + "\n";
            snapDetails += "Snapped to vertex of A: " + vertexA + "\n";
            snapDetails += "Snap distance: " + snapDistance + ".";

            // Build snap result
            // Parse start co-ord (vertexB) and snapped co-ord (vertexA) to calculateSnapped() method to obtain snapped vertices of B
            result.setVerticesBSnapped(GeometryUtil.calculateSnapped(vertexB, vertexA, verticesB));
            result.setSnapped(true);
            result.setSnapDetails(snapDetails);

            return result;
        }
        else if (GeometryUtil.calculateClosestMidpoint(shapeA, shapeB).getDistance() <= MIDPOINT_SNAP){

            // Store snap information in PointData object
            PointData pointData = GeometryUtil.calculateClosestMidpoint(shapeA, shapeB);
            Coord midpoint = pointData.getPointA(); // Midpoint of A that activated the snap
            Coord vertexB = pointData.getPointB(); // Vertex of B that activated the snap
            double snapDistance = pointData.getDistance();

            // Build snap details:
            snapDetails += "Vertex to midpoint snap occurred." + "\n";
            snapDetails += "Vertex of B: " + vertexB + "\n";
            snapDetails += "Snapped to midpoint of A: " + midpoint + "\n";
            snapDetails += "Snap distance: " + snapDistance + ".";

            // Build snap result
            // Parse start co-ord (vertexB) and snapped co-ord (midpoint) to calculateSnapped() method to obtain snapped vertices of B
            result.setVerticesBSnapped(GeometryUtil.calculateSnapped(vertexB, midpoint, verticesB));
            result.setSnapped(true);
            result.setSnapDetails(snapDetails);

            return result;
        }
        else if (GeometryUtil.calculateClosestPoint(shapeA, shapeB).getDistance() <= POINT_SNAP){

            // Store snap information in PointData object
            PointData pointData = GeometryUtil.calculateClosestPoint(shapeA, shapeB);
            Coord point = pointData.getPointA(); // Line point of A that activated the snap
            Coord vertexB = pointData.getPointB(); // Vertex of B that activated the snap
            double snapDistance = pointData.getDistance();

            // Build snap details:
            snapDetails += "Vertex to line point snap occurred." + "\n";
            snapDetails += "Vertex of B: " + vertexB + "\n";
            snapDetails += "Snapped to midpoint of A: " + point + "\n";
            snapDetails += "Snap distance: " + snapDistance + ".";

            // Build snap result
            // Parse start co-ord (vertexB) and snapped co-ord (point) to calculateSnapped() method to obtain snapped vertices of B
            result.setVerticesBSnapped(GeometryUtil.calculateSnapped(vertexB, point, verticesB));
            result.setSnapped(true);
            result.setSnapDetails(snapDetails);

            return result;
        }
        else {
            result.setSnapDetails("No snap occurred");
            return result;
        }
    }
}
