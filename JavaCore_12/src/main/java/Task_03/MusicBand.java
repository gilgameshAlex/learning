package Task_03;

public class MusicBand {
    private String name;
    private int year;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return new StringBuilder("").append(this.name).append(" ").append(this.year).toString();
    }
}
