package Task_01;

public class main {
    public static void main(String[] args) {
        String res = "";
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            res += i + " ";
        }
        long finish1 = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(finish1 - start1);

        long start2 = System.currentTimeMillis();
        StringBuilder res1 = new StringBuilder("");
        for (int i = 0; i < 20000; i++) {
            res1.append(i).append(" ");
        }
        long finish2 = System.currentTimeMillis();
        //System.out.println(res1);
        System.out.println(finish2 - start2);
    }
}
