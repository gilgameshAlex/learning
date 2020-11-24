package Task_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.parseFileToStringList());
    }
    public static List<String> parseFileToStringList() {
        List<String> list = new ArrayList<>();
        File file = new File("people.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line  = scanner.nextLine();
                if (Integer.parseInt(line.split(" ")[1]) < 0) {
                    scanner.close();
                    throw new CustomException();
                }
                list.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (CustomException e) {
            System.out.println("Некорректный входной файл");
            return new ArrayList<String>();
        }
        return list;
    }
}
