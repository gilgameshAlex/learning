package Task_02;

public abstract class Figure {
    protected String color;

    public Figure() {
        color = "";
    }

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();
}
