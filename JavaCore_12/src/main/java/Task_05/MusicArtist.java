package Task_05;

public class MusicArtist {
    private String name;
    private int year;

    public MusicArtist(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return new StringBuilder("Имя артиста: ").append(this.name).append("; возраст: ").append(this.year).toString();
    }
}
