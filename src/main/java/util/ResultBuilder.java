package util;

import geometry.Coord;
import model.PointData;
import model.SnapResult;

// Class and method to contain boilerplate code when building snap result
public class ResultBuilder {

    public static SnapResult buildResult(PointData pointData, SnapResult snapResult, String snapType, Coord[] verticesB) {

        // Store snap information in PointData object
        String snapDetails = "";
        Coord vertexA = pointData.getPointA(); // Vertex / midpoint / point of A that activated the snap
        Coord vertexB = pointData.getPointB(); // Vertex of B that activated the snap
        double snapDistance = pointData.getDistance();

        // Build snap details:
        snapDetails += "Vertex to " + snapType +  " snap occurred." + "\n";
        snapDetails += "Vertex of B: " + vertexB + "\n";
        snapDetails += "Snapped to " + snapType + " of A: " + vertexA + "\n";
        snapDetails += "Snap distance: " + snapDistance + ".";

        // Build snap result
        // Parse start co-ord (vertexB) and snapped co-ord (vertexA) to calculateSnapped() method to obtain snapped vertices of B
        snapResult.setVerticesBSnapped(GeometryUtil.calculateSnapped(vertexB, vertexA, verticesB));
        snapResult.setSnapped(true);
        snapResult.setSnapDetails(snapDetails);
        System.out.println(snapDetails);

        return snapResult;
    }
}
