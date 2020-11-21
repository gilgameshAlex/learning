package Task_01;

public class Motorbike extends VehicleParams {
    public Motorbike() {}
    public Motorbike(int _year, String _color, String _model) {
        this.year = _year;
        this.color = _color;
        this.model = _model;
    }
    public void info() {
        System.out.println("Это мотоцикл");
    }
}
