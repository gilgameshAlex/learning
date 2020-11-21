package Task_01;

public class main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("Кто-то", 2999, 1000, 5000);
        airplane.setYear(2020);
        airplane.setLength(3000);
        airplane.fillUp(10);
        airplane.fillUp(20);
        airplane.info();

        Airplane.compareAirplanes(airplane, new Airplane("Кто-то", 2999, 3000, 5000));
        Airplane.compareAirplanes(airplane, new Airplane("Кто-то", 2999, 3001, 5000));
        Airplane.compareAirplanes(airplane, new Airplane("Кто-то", 2999, 2999, 5000));
    }
}
