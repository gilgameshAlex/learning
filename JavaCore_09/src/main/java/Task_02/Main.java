package Task_02;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, "RED");
        System.out.printf("Круг: площадь - %.3f, периметр - %.3f\n", circle.area(), circle.perimeter());

        Rectangle rectangle = new Rectangle(5, 2, "GREEN");
        System.out.printf("Прямоугольник: площадь %.3f, периметр - %.3f\n", rectangle.area(), rectangle.perimeter());

        Triangle triangle = new Triangle(2, 3, 4, "BLACK");
        System.out.printf("Треугольник: площадь %.3f, периметр - %.3f\n", triangle.area(), triangle.perimeter());

    }
}
