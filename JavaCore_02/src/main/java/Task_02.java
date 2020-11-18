import java.util.Scanner;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a >= b) {
            System.out.println("Некорректный ввод");
            return;
        }

        if (a % 5 != 0) a += 5 - (a % 5);
        else a += 5;

        for (; a < b; a += 5) {
            if (a % 5 == 0 && a % 10 != 0) System.out.print(a + " ");
        }
    }
}
