package lesson4;

public class MainTriangle {
    public static void main(String[] args) throws ThisIsNotTriangleException {
        TriangleClass triangleClass = new TriangleClass();
        System.out.println(triangleClass.triangleSquare(4, 5, 7));
    }
}
