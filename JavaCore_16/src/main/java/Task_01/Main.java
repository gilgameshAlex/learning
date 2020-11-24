package Task_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        Main.printResult(file);
    }

    public static void printResult(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return;
        }
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            int sum = 0;
            for (String number : lineSplit) {
                sum += Integer.parseInt(number);
            }
            double res = (double) sum / lineSplit.length;
            System.out.println("Числа в txt файле: " + line);
            System.out.printf("Ответ: %.15f --> %.3f", res, res);
        }
        scanner.close();
    }
}
