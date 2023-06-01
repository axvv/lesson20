package lesson4;

public class TriangleClass {


    public int triangleSquare(int a, int b, int c) throws ThisIsNotTriangleException {
        if (testValue(a, b, c)) throw new ThisIsNotTriangleException("С такими сторонами треугольников не бывает");


        //        находим полупериметр треугольника
        float p = (float)(a + b + c) / 2;

//        находим площадь треугольника по формуле Герона

        int result = (int)Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    private boolean testValue(int a, int b, int c) {

        return a < 0 || b < 0 || c < 0 ||
                a == 0 || b == 0 || c == 0 ||
                a + b <= c || b + c <= a || c + a <= b;
    }
}

