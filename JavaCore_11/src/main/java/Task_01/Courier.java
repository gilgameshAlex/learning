package Task_01;

public class Courier implements Worker {
    private double curSalary = 100;
    private double prizeCoefficient = 2;
    private double salary;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
        this.salary = 0;
        this.warehouse = warehouse;
    }

    public Courier(double salary, Warehouse warehouse) {
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
        this.warehouse.changeBalance(1000);
        if (this.warehouse.getBalance() >= Warehouse.BALANCE_PRIZE)
            this.salary += bonus();
        else
            this.salary += this.curSalary;
    }

    public double bonus() {
        return this.curSalary * this.prizeCoefficient;
    }

    @Override
    public String toString() {
        return new StringBuilder("").append("Курьер заработал: ").append(this.salary).toString();
    }
}
