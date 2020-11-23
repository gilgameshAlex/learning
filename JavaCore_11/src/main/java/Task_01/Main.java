package Task_01;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Picker picker = new Picker(warehouse);
        Courier courier = new Courier(warehouse);
        for (int i = 0; i < 1505; i++)
        {
            picker.doWork();
            courier.doWork();
        }
        System.out.println("Склад 1");
        System.out.println(warehouse);
        System.out.println(picker);
        System.out.println(courier);

        Warehouse warehouse1 = new Warehouse();
        Picker picker1 = new Picker(warehouse1);
        Courier courier1 = new Courier(warehouse1);
        picker1.doWork();
        courier1.doWork();

        System.out.println("Склад 2");
        System.out.println(warehouse1);
        System.out.println(picker1);
        System.out.println(courier1);

        System.out.println("Склад 1");
        System.out.println(warehouse);
        System.out.println(picker);
        System.out.println(courier);

    }
}
