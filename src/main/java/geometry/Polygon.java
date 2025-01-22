package geometry;

import java.util.ArrayList;

// Class that creates a Polygon object from a list of vertices (array of Coord objects)
// Calculates and stores list of midpoints and equally spaced points from the list of vertices
// Will allow later methods to calculate the closest vertex / midpoint / point much easier
public class Polygon {
    private Coord[] vertices;
    private ArrayList<Coord> midpoints;
    private ArrayList<Coord> points;


    public Polygon(Coord[] vertices) {
        this.vertices = vertices;
        this.midpoints = calculateMidpoints(); // Initialize list of midpoints with generated list from vertices
        this.points = calculateLinePoints(); // Initialize list of points with generated equally spaced points from list of vertices
    }

    public Coord[] getvertices() {
        return vertices;
    }

    public ArrayList<Coord> getMidpoints() {
        return midpoints;
    }

    public ArrayList<Coord> getPoints() {
        return points;
    }

    // Method to generate a list of all midpoints between vertices of a shape
    private ArrayList<Coord> calculateMidpoints() {
        ArrayList<Coord> midpoints = new ArrayList<>();
        Coord coordA;
        Coord coordB;

        for(int i = 0; i <= vertices.length - 1; i++) {
            coordA = vertices[i];

            if (i == vertices.length - 1) {
                coordB = vertices[0]; // Length from the last vertex to the first
            } else {
                coordB = vertices[i + 1];
            }

            // Formula to calculate midpoint of a line with two known points
            double midpointX = (coordA.getX() + coordB.getX()) / 2;
            double midpointY = (coordA.getY() + coordB.getY()) / 2;
            midpoints.add(new Coord(midpointX, midpointY));
        }
        return midpoints;
    }

    // Method to generate evenly spaced points between vertices
    private ArrayList<Coord> calculateLinePoints() {
        ArrayList<Coord> points = new ArrayList<>();
        
        for (int i = 0; i < vertices.length; i++) {
            Coord coordA = vertices[i];
            Coord coordB = vertices[(i + 1) % vertices.length];
            double deltaX = coordB.getX() - coordA.getX();
            double deltaY = coordB.getY() - coordA.getY();

            // Linear interpolation formula to calculate equally spaced points between two known points
            for (int j = 1; j < 10; j++) {
                double t = (double) j / 10;
                double pointX = coordA.getX() + t * deltaX;
                double pointY = coordA.getY() + t * deltaY;
                points.add(new Coord(pointX, pointY));
            }
        }
        return points;
    }
}
