package Task_02;

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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        res.append("Изготовитель: ").append(this.producer)
                .append(", год выпуска: ").append(this.year)
                .append(", длина: ").append(this.length)
                .append(", вес: ").append(this.weight)
                .append(", количество топлива в баке: ").append(this.fuel);
        return res.toString();
    }
}
