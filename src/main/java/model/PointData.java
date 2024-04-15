package model;

import geometry.Coord;

public class PointData {
    private final Coord pointA;
    private final Coord pointB;
    private final double distance;

    public PointData(Coord pointA, Coord pointB, double distance) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.distance = distance;
    }

    public Coord getPointA() {
        return pointA;
    }
    public Coord getPointB() {
        return pointB;
    }
    public double getDistance() {
        return distance;
    }
    @Override
    public String toString(){
        return "(" + pointA + ". " + pointB + ", " + distance + ")";
    }
}
