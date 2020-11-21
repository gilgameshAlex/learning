package Task_01;

public class Airplane {
    private String producer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void info()
    {
        System.out.printf("Изготовитель: " + this.producer);
        System.out.printf(", год выпуска: " + this.year);
        System.out.printf(", длина: " + this.length);
        System.out.printf(", вес: " + this.weight);
        System.out.println(", количество топлива в баке: " + this.fuel);
    }

    public void fillUp(int _fuel)
    {
        this.fuel += _fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setYear(int _year) {
        this.year = _year;
    }

    public void setLength(int _length) {
        this.length = _length;
    }

    public int getLength() {
        return length;
    }

    public static void compareAirplanes(Airplane a, Airplane b) {
        System.out.println("Длиннее самолёт - " + (a.getLength() > b.getLength() ? "1" : a.getLength() != b.getLength() ? "2" : "оба равные по длине"));
    }
}
