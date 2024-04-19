package model;

import geometry.Coord;

// Class to contain all information required for dragMove() function output
public class SnapResult {
    private Coord[] verticesBSnapped;
    private boolean isSnapped;
    private String snapDetails;

    public SnapResult(Coord[] verticesB) {
        this.verticesBSnapped = verticesB;
        isSnapped = false;
    }

    public void setVerticesBSnapped(Coord[] verticesBSnapped) {
        this.verticesBSnapped = verticesBSnapped;
    }

    public void setSnapped(boolean snapped) {
        isSnapped = snapped;
    }

    public void setSnapDetails(String snapDetails) {
        this.snapDetails = snapDetails;
    }
}
