import function.DragMove;
import geometry.Coord;

public class Main {
    public static void main(String[] args) {

        Coord[] verticesA = {
                new Coord(100, 0),
                new Coord(-100, 0),
                new Coord(100, 100),
                new Coord(-100, 100)
        };
        Coord[] verticesB = {
                new Coord(0, -14),
                new Coord(5, -16),
                new Coord(-5, 16)
        };
//        Coord[] verticesB = {
//                new Coord(20,20),
//                new Coord(21,21),
//                new Coord(22,22)
//        };
//        Coord[] verticesB = {
//                new Coord(15, -5),
//                new Coord(5, -16),
//                new Coord(-5, 16)
//        };
//        Coord[] verticesB = {
//                new Coord(99, 99),
//                new Coord(80, 80),
//                new Coord(70, 70)
//        };

        DragMove.dragMove(verticesA, verticesB);
    }
}
