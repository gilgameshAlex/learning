package Task_02;

public class TestFigures {
    public static void main(String[] args) {
        Figure[] figures = {
            new Triangle ( 10 , 10 , 10 , "Red" ),
            new Triangle ( 10 , 20 , 30 , "Green" ),
            new Triangle ( 10 , 20 , 15 , "Red" ),
            new Rectangle ( 5 , 10 , "Red" ),
            new Rectangle ( 40 , 15 , "Orange" ),
            new Circle ( 4 , "Red" ),
            new Circle ( 10 , "Red" ),
            new Circle ( 5 , "Blue" )
        };
        System.out.printf("Сумма площадей красных фигур = %.3f\n", TestFigures.calculateRedArea(figures));
        System.out.printf("Сумма периметров красных фигур = %.3f\n",TestFigures.calculateRedPerimeter(figures));
    }
    public static double calculateRedPerimeter(Figure[] figures) {
        double sum = 0;
        for (Figure figure : figures) {
            if (figure.getColor().equals("Red")) sum += figure.perimeter();
        }
        return sum;
    }
    public static double calculateRedArea(Figure[] figures) {
        double sum = 0;
        for (Figure figure : figures) {
            if (figure.getColor().equals("Red")) sum += figure.area();
        }
        return sum;
    }
}
