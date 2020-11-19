import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] arr = new int [n];
        int[] resParam = new int[4];
        Random random = new Random();
        int sum = 0;
        System.out.println("Введено число " + n + ". Сгенерирован следующий массив:");
        for (int i = 0; i < n; i++) {
            int randVal = random.nextInt(10);
            arr[i] = randVal;
            if (randVal > 8) resParam[0]++;
            if (randVal == 1) resParam[1]++;
            if (randVal % 2 == 0) resParam[2]++;
            if (randVal % 2 != 0) resParam[3]++;
            sum += randVal;

        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Информация о массиве:\nДлина массива: " + arr.length);
        System.out.println("Количество чисел больше 8: " + resParam[0]);
        System.out.println("Количество чисел равных 1: " + resParam[1]);
        System.out.println("Количество четных чисел: " + resParam[2]);
        System.out.println("Количество нечетных чисел: " + resParam[3]);
        System.out.println("Сумма всех элементов массива: " + sum);
    }
}
