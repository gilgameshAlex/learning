package Task_01;

public class Picker implements Worker {
    private double curSalary = 80;
    private double prizeCoefficient = 3;
    private double salary;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        this.salary = 0;
        this.warehouse = warehouse;
    }

    public Picker(double salary, Warehouse warehouse) {
        this.salary = salary;
        this.warehouse = warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double getSalary() {
        return salary;
    }

    public void doWork() {
        this.warehouse.incrementCountOrder();
        if (this.warehouse.getCountOrder() >= Warehouse.COUNT_ORDER_PRIZE)
            this.salary += bonus();
        else
            this.salary += curSalary;
    }

    public double bonus() {
        return this.curSalary * this.prizeCoefficient;
    }

    @Override
    public String toString() {
        return new StringBuilder("").append("Сборщик заработал: ").append(this.salary).toString();
    }
}
