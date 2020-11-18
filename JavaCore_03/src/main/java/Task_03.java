import java.math.BigDecimal;
import java.util.Scanner;

public class Task_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            BigDecimal bigDecimal_a = new BigDecimal(a);
            BigDecimal bigDecimal_b = new BigDecimal(b);
            System.out.println((bigDecimal_a.scale() == 0 ? String.format("%.0f", a) : a) +
                    " " +
                    (bigDecimal_b.scale() == 0 ? String.format("%.0f", b) : b) +
                    " - ваш ввод в консоль");
            if (b == 0) {
                System.out.println("Деление на 0 - ответ программы");
                continue;
            }
            System.out.println((a / b) + " - ответ программы");
        }
    }
}
