package Task_03;

import Task_02.CustomException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> parseFileToObjList(){
        List<Person> list = new ArrayList<>();
        File file = new File("people.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line  = scanner.nextLine();
                String[] listSplit = line.split(" ");
                int age = Integer.parseInt(listSplit[1]);
                if (age < 0) throw new CustomException();
                list.add(new Person(listSplit[0], age));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (CustomException e) {
            System.out.println("Некорректный входной файл");
            return new ArrayList<Person>();
        }
        return list;
    }

    @Override
    public String toString() {
        return new StringBuilder("{name='").append(this.name).append("', year=").append(this.age).append("}").toString();
    }
}
