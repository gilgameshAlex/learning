package Task_02;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        for(int i = 0; i <= 30; i+=2) {
            list.add(i);
        }
        System.out.println(list);
        for(int i = 300; i <= 350; i+=2) {
            list.add(i);
        }
        System.out.println(list);
    }
}
