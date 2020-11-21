package Task_02;

public class main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("Кто-то", 2999, 1000, 5000);
        airplane.setYear(2020);
        airplane.setLength(3000);
        airplane.fillUp(10);
        airplane.fillUp(20);
        airplane.info();
    }
}
