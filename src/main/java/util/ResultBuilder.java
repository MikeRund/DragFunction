package util;

import geometry.Coord;
import model.PointData;
import model.SnapResult;

// Class and method to contain boilerplate code when building snap result
public class ResultBuilder {

    public static SnapResult buildResult(PointData pointData, SnapResult snapResult, String snapType, Coord[] verticesB) {

        // Store snap information in PointData object
        Coord vertexA = pointData.getPointA(); // Vertex / midpoint / point of A that activated the snap
        Coord vertexB = pointData.getPointB(); // Vertex of B that activated the snap
        double snapDistance = pointData.getDistance();

        // Build snap details:
        String snapDetails =  String.format("Vertex to %s snap occurred. \nVertex of B: %s \nSnapped to %s of A: %s \nSnap distance: %s",
                snapType, vertexB, snapType, vertexA, snapDistance);

        // Build snap result
        // Parse start co-ord (vertexB) and snapped co-ord (vertexA) to calculateSnapped() method to obtain snapped vertices of B
        snapResult.setVerticesBSnapped(GeometryUtil.calculateSnapped(vertexB, vertexA, verticesB));
        snapResult.setSnapped(true);
        snapResult.setSnapDetails(snapDetails);
        System.out.println(snapDetails);

        return snapResult;
    }
}
