package function;

import geometry.Coord;
import geometry.Polygon;
import model.PointData;
import model.SnapResult;
import util.GeometryUtil;
import util.ResultBuilder;

public class Dragmove {
    static final double VERTEX_SNAP = 20;
    static final double MIDPOINT_SNAP = 15;
    static final double POINT_SNAP = 10;
    public static SnapResult dragMove(Coord[] verticesA, Coord[] verticesB){

        // Initialize snap result, snap details and parse the vertices into the Polygon constructor
        SnapResult result = new SnapResult(verticesB);
        String snapDetails = "";
        Polygon shapeA = new Polygon(verticesA);
        Polygon shapeB = new Polygon(verticesB);

        // Check if any vertex of A is within 20 points to any vertex of B
        if (GeometryUtil.calculateClosestVertex(shapeA, shapeB).getDistance() <= VERTEX_SNAP) {

            PointData pointData = GeometryUtil.calculateClosestVertex(shapeA, shapeB);
            return ResultBuilder.buildResult(pointData, result, "vertex", verticesB);
        }

        // Check if any midpoint of A is within 15 points to any vertex of B
        else if (GeometryUtil.calculateClosestMidpoint(shapeA, shapeB).getDistance() <= MIDPOINT_SNAP){

            PointData pointData = GeometryUtil.calculateClosestMidpoint(shapeA, shapeB);
            return ResultBuilder.buildResult(pointData, result, "midpoint", verticesB);
        }

        // Check if any point of A is within 10 points to any vertex of B
        else if (GeometryUtil.calculateClosestPoint(shapeA, shapeB).getDistance() <= POINT_SNAP){

            PointData pointData = GeometryUtil.calculateClosestPoint(shapeA, shapeB);
            return ResultBuilder.buildResult(pointData, result, "point", verticesB);
        }

        // No distance criteria met
        else {
            snapDetails += "No snap occurred";
            result.setSnapDetails(snapDetails);
            System.out.println(snapDetails);
            return result;
        }
    }
}
