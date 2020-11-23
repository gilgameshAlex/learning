package Task_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("LADA");
        list.add("NISSAN");
        list.add("BMW");
        list.add("KIA");
        list.add("MERCEDES");
        System.out.println(list);
        list.add(2, "TEST");
        System.out.println(list);
        //list.remove(5);
        list.remove("MERCEDES");
        System.out.println(list);
    }
}
