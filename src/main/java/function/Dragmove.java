package function;

import geometry.Coord;
import geometry.Polygon;
import model.SnapResult;
import util.GeometryUtil;

public class Dragmove {
    static final double VERTEX_SNAP = 20;
    static final double MIDPOINT_SNAP = 15;
    static final double POINT_SNAP = 10;
    public static SnapResult dragmove(Coord[] verticesA, Coord[] verticesB){
        SnapResult result = new SnapResult(verticesB);
        Polygon shapeA = new Polygon(verticesA);
        Polygon shapeB = new Polygon(verticesB);

        if (GeometryUtil.calculateClosestVertex(shapeA, shapeB).getDistance() <= VERTEX_SNAP) {
            System.out.println("Vertex snap");
        }
        else if (GeometryUtil.calculateClosestMidpoint(shapeA, shapeB).getDistance() <= MIDPOINT_SNAP){
            System.out.println("Midpoint snap");
        }
        else if (GeometryUtil.calculateClosestPoint(shapeA, shapeB).getDistance() <= POINT_SNAP){
            System.out.println("Point snap");
        }
        else {
            System.out.println("No snap");
        }
        return result;
    }
}
