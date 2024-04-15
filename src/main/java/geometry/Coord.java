package geometry;

// Class to store co-ordinates as an object
// Will allow creation of Polygon object, and easy handling of closest point
public class Coord {
    private final double x;
    private final double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
