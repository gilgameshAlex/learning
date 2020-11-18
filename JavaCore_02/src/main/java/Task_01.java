import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floor = scanner.nextInt();
        if (floor >= 1 && floor <= 4) {
            System.out.println("Малоэтажный дом");
            return;
        }
        if (floor >= 5 && floor <= 8) {
            System.out.println("Среднеэтажный дом");
            return;
        }
        if (floor >= 9) {
            System.out.println("Многоэтажный дом");
            return;
        }
        System.out.println("Ошибка ввода");
    }
}
