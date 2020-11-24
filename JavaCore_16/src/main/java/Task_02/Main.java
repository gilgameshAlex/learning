package Task_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        PrintWriter writer1 = null;
        PrintWriter writer2 = null;
        try {
            writer1 = new PrintWriter(file1);
            writer2 = new PrintWriter(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int randVal = 0;
        Random random = new Random();
        for (int i = 0; i < 999; i++) {
            randVal = random.nextInt(1001);
            writer1.print(randVal + " ");
        }
        randVal = random.nextInt(1001);
        writer1.print(randVal);
        writer1.close();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int count = 0;
            int sum = 0;
            for (String number : numbers)
            {
                sum += Integer.parseInt(number);
                count++;
                if (count == 4)
                {
                    double res = (double)sum / count;
                    writer2.print(res + " ");
                    sum = 0;
                    count = 0;
                }
            }
        }
        scanner.close();
        writer2.close();
        Main.printResult(file2);
    }

    public static void printResult(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double sum = 0;
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                sum += Double.parseDouble(number);
            }
        }
        scanner.close();
        System.out.printf("Ответ: %d", (int) sum);
    }
}
