import java.util.Random;

public class Task_02 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(10000);
        }
        int max = 0;
        int min = 10000;
        int equalZero = 0;
        int sumZero = 0;
        for (int i : arr)
        {
            if (i > max) max = i;
            if (i < min) min = i;
            if (i % 10 == 0) {
                equalZero ++;
                sumZero += i;
            }
        }
        System.out.println(max + " - наибольший элемент массива");
        System.out.println(min + " - наименьший элемент массива");
        System.out.println(equalZero + " - количество элементов массива, оканчивающихся на 0");
        System.out.println(sumZero + " - сумма элементов массива, оканчивающихся на 0");
    }
}
