package Task_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        Main.printSumDigits(file);
    }
    public static void printSumDigits(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String[] line = scanner.nextLine().split(" ");
            if (line.length < 10 || line.length > 10) {
                scanner.close();
                throw new CustomException("Некорректный входной файл");
            }
            int sum = 0;
            for (String number : line) {
                sum += Integer.parseInt(number);
            }
            System.out.printf("Сумма = %d\n", sum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (CustomException e){return;}
    }
}
