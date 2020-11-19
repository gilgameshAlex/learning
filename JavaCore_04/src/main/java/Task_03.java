import java.util.Random;

public class Task_03 {
    public static void main(String[] args) {
        int m = 12;
        int n = 8;
        int[][] arr = new int[m][n];
        Random random = new Random();
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                int randVal = random.nextInt(50);
                System.out.print(randVal + " ");
                arr[i][j] = randVal;
                rowSum += randVal;
            }
            System.out.print("// сумма - " + rowSum);
            if (rowSum >= max) {
                max = rowSum;
                indexMax = i;
            }
            System.out.println("");
        }
        System.out.println("Ответ: " + indexMax + " (индекс строки, сумма чисел в которой максимальна)");
    }
}
