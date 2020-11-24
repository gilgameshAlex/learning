package Task_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().writeFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() throws FileNotFoundException {
        final String separator = ";";
        File file = new File("src" + File.separator + "main" + File.separator +
                "resources" + File.separator + "shoes.csv");
        File file1 = new File("src" + File.separator + "main" + File.separator +
                "resources" + File.separator + "missing_shoes.txt");
        Scanner scanner = new Scanner(file);
        PrintWriter writer = new PrintWriter(file1);
        if (scanner.hasNextLine()) {
            scanner.nextLine(); //пропускаем шапку
        }
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] lineSplit = line.split(separator);
            if (lineSplit.length > 3 || lineSplit.length < 3) {
                System.out.println(new StringBuilder("Некорректная строка файла: ").append(line));
                continue;
            }
            if (Integer.parseInt(lineSplit[2]) == 0) {
                //writer.println(String.join(",", lineSplit));
                writer.append(String.join(",", lineSplit) + "\n");
            }
        }
        scanner.close();
        writer.close();
    }
}
