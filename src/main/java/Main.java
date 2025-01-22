import function.DragMove;
import geometry.Coord;

public class Main {
    public static void main(String[] args) {

        // Dummy data to satisfy each condition of algorithm
        Coord[] verticesA = {
                new Coord(100, 0),
                new Coord(-100, 0),
                new Coord(100, 100),
                new Coord(-100, 100)
        };
        Coord[] verticesB_vertexEx = {
                new Coord(90, -5),
                new Coord(20,20),
                new Coord(30,30)
        };
        Coord[] verticesB_midpointEx = {
                new Coord(10,-5),
                new Coord(20,20),
                new Coord(30,30)
        };
        Coord[] verticesB_pointEx = {
                new Coord(60,-5),
                new Coord(20,20),
                new Coord(30,30)
        };
        Coord[] verticesB_noSNap = {
                new Coord(20,20),
                new Coord(21,21),
                new Coord(22,22)
        };

        System.out.println("Vertex snap example:");
        System.out.println(DragMove.dragMove(verticesA, verticesB_vertexEx) + "\n");

        System.out.println("Midpoint snap example:");
        System.out.println(DragMove.dragMove(verticesA, verticesB_midpointEx)  + "\n");

        System.out.println("Point snap example:");
        System.out.println(DragMove.dragMove(verticesA, verticesB_pointEx)  + "\n");
        
        System.out.println("No snap example:");
        System.out.println(DragMove.dragMove(verticesA, verticesB_noSNap)  + "\n");

    }
}
