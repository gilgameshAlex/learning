package Transport;

public class VehicleParams {
    public int year;
    public String color;
    public String model;
    public VehicleParams () {
        this.year = 0;
        this.color = "";
        this.model = "";
    }
    public int getYear() {
        return this.year;
    }
    public String getColor() {
        return this.color;
    }
    public String getModel() {
        return this.model;
    }
}
