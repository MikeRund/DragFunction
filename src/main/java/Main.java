import geometry.Coord;
import geometry.Polygon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        // Define some vertices for testing
//        Coord[] vertices = {
//                new Coord(2, 4),
//                new Coord(5 , 8),
//                new Coord(-3, 6),
//                new Coord(0, -2),
//                new Coord(7, 3)
//
//        };
//
//        // Create a polygon
//        Polygon polygon = new Polygon(vertices);
//
//        // Get the midpoints
//        ArrayList<Coord> midpoints = polygon.getMidpoints();
//        for(Coord mid : midpoints) {
//            System.out.println(mid.getX() + " , " + mid.getY());
//        }

        // Point test
        Coord[] vertices = {
                new Coord(0,0),
                new Coord(1,0),
                new Coord(0,1)
        };
        Polygon triangle = new Polygon(vertices);
        ArrayList<Coord> points = triangle.getPoints();
        for (Coord point : points){
            System.out.println(point.getX() + " , " + point.getY());
        }
    }
}
