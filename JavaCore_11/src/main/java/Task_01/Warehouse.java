package Task_01;

public class Warehouse {
    public final static int COUNT_ORDER_PRIZE = 1500;
    public final static int BALANCE_PRIZE = 1000000;
    private int countOrder;
    private double balance;

    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCountOrder() {
        return countOrder;
    }

    public double getBalance() {
        return balance;
    }

    public void incrementCountOrder() {
        this.countOrder++;
    }

    public void changeBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return new StringBuilder("").append("Кол-во собранных заказов: ").append(this.countOrder)
                .append("\nДоход от доставки: ").append(this.balance).toString();
    }
}
