package Task_01;

public abstract  class VehicleParams {
    protected int year;
    protected String color;
    protected String model;
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
    public void setYear(int _year) {
        this.year = _year;
    }
    public void setColor(String _color) {
        this.color = _color;
    }
    public void setModel(String _model) {
        this.model = _model;
    }
    public int yearDifference(int _year) {
        int res = this.year - _year;
        if (res < 0) res *= -1;
        return res;
    }
}
