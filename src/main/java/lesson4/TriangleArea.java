package lesson4;

public class TriangleArea {

    public static void main( String[] args )
    {
        double a;

        a = triangleArea(3, 4, 5);
        System.out.println("Площадь треугольника со сторонами 3, 4, 5 равна:" + a);

    }

    public static double triangleArea( int a, int b, int c )
    {
        double hp = (a + b + c) / 2.0;
        return Math.sqrt(hp * (hp - a) * (hp - b) * (hp - c));

    }
}
