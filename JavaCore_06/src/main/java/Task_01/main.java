package Task_01;

public class main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setYear(2000);
        car.setModel("X-100500");
        car.setColor("white");
        car.info();
        System.out.println("Год выпуска: " + car.getYear());
        System.out.println("Модель: " + car.getModel());
        System.out.println("Цвет: " + car.getColor());
        System.out.println("Разница: " + car.yearDifference(2100));
        System.out.println("Разница: " + car.yearDifference(1900));

        Motorbike motorbike = new Motorbike(1000, "X-500", "black");
        motorbike.info();
        System.out.println("Год выпуска: " + motorbike.getYear());
        System.out.println("Модель: " + motorbike.getModel());
        System.out.println("Цвет: " + motorbike.getColor());
        System.out.println("Разница: " + motorbike.yearDifference(900));
        System.out.println("Разница: " + motorbike.yearDifference(1100));
    }
}
