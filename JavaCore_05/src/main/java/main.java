import Transport.*;

public class main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setYear(2000);
        car.setModel("X-100500");
        car.setColor("white");
        System.out.println("Год выпуска: " + car.getYear());
        System.out.println("Модель: " + car.getModel());
        System.out.println("Цвет: " + car.getColor());

        Motorbike motorbike = new Motorbike(1000, "X-500", "black");
        System.out.println("Год выпуска: " + motorbike.getYear());
        System.out.println("Модель: " + motorbike.getModel());
        System.out.println("Цвет: " + motorbike.getColor());

        Motorbike motorbike1 = new Motorbike();
        motorbike1.year = 1001;
        motorbike1.model = "X-501";
        motorbike1.color = "green";
        System.out.println("Год выпуска: " + motorbike1.getYear());
        System.out.println("Модель: " + motorbike1.getModel());
        System.out.println("Цвет: " + motorbike1.getColor());
    }
}
