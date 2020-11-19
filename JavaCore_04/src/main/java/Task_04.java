import java.util.Arrays;
import java.util.Random;

public class Task_04 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        int indexMax = 0;
        for (int i = 1; i < n - 1; i++) {
            int localSum = arr[i - 1] + arr[i] + arr[i + 1];
            if (localSum > max) {
                max = localSum;
                indexMax = i - 1;
            }
        }
        int res[] = new int[3];
        System.arraycopy(arr, indexMax, res, 0, 3);
        System.out.println("Тройка с максимальной суммой: " + Arrays.toString(res));
        System.out.println(max + "\n" + indexMax);
    }
}
