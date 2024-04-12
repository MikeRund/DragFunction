package geometry;

import java.util.ArrayList;

public class Polygon {
    private Coord[] verticies;
    private ArrayList<Coord> midpoints;
    private ArrayList<Coord> points;


    public Polygon(Coord[] verticies) {
        this.verticies = verticies;
        this.midpoints = calculateMidpoints();
        this.points = calculateLinePoints();
    }

    public Coord[] getVerticies() {
        return verticies;
    }

    public ArrayList<Coord> getMidpoints() {
        return midpoints;
    }

    public ArrayList<Coord> getPoints() {
        return points;
    }

    // Method to generate a list of all midpoints between verticies of a shape
    private ArrayList<Coord> calculateMidpoints() {
        ArrayList<Coord> midpoints = new ArrayList<>();
        Coord coordA;
        Coord coordB;
        for(int i = 0; i <= verticies.length - 1; i++) {
            coordA = verticies[i];

            if (i == verticies.length - 1) {
                coordB = verticies[0]; // Length from the last vertex to the first
            } else {
                coordB = verticies[i + 1];
            }
            double midpointX = (coordA.getX() + coordB.getX()) / 2;
            double midpointY = (coordA.getY() + coordB.getY()) / 2;
            midpoints.add(new Coord(midpointX, midpointY));
        }
        return midpoints;
    }

    // Method to generate 10 evenly spaced points between verticies
    private ArrayList<Coord> calculateLinePoints() {
        ArrayList<Coord> points = new ArrayList<>();
        for (int i = 0; i < verticies.length; i++) {
            Coord coordA = verticies[i];
            Coord coordB = verticies[(i + 1) % verticies.length];
            double deltaX = coordB.getX() - coordA.getX();
            double deltaY = coordB.getY() - coordA.getY();

            // Linear interpolation to calculate equally spaced points
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
