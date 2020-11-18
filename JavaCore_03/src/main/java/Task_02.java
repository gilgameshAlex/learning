import java.math.BigDecimal;
import java.util.Scanner;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            BigDecimal bigDecimal_a = new BigDecimal(a);
            BigDecimal bigDecimal_b = new BigDecimal(b);
            System.out.println((bigDecimal_a.scale() == 0 ? String.format("%.0f", a) : a) +
                    " " +
                    (bigDecimal_b.scale() == 0 ? String.format("%.0f", b) : b) +
                    " - ваш ввод в консоль");
            if (b == 0) break;
            double res = a / b;
            if (new BigDecimal(res).scale() == 0)
                System.out.println(String.format("%.0f", res) + " - ответ программы");
            else
                System.out.println(res + " - ответ программы");
        } while (true);
    }
}
