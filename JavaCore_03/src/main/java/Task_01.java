import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in;
        String data_txt = "Москва, Владивосток, Ростов - Россия\n" +
                "Рим, Милан, Турин - Италия\n" +
                "Ливерпуль, Манчестер, Лондон - Англия\n" +
                "Берлин, Мюнхен, Кёльн - Германия";
        String[] arrData = data_txt.split("\n");
        int arrDataLength = arrData.length;
        String[][] arrDataRes = new String[arrDataLength][];
        for (int i = 0; i < arrDataLength; i++) {
            String[] tempArr = arrData[i].split(" - ");
            arrDataRes[i] = new String[tempArr.length];
            for (int j = 0; j < tempArr.length; j++) {
                arrDataRes[i][j] = tempArr[j];
            }
        }
        Boolean existCountry;
        do {
            existCountry = false;
            in = scanner.nextLine();
            System.out.println(in + " - ваш ввод в консоль");
            if (in.equals("Stop")) break;
            else {
                for (int i = 0; i < arrDataLength; i++) {
                    if (arrDataRes[i][0].indexOf(in) != -1) {
                        System.out.println(arrDataRes[i][1] + " - ответ программы");
                        existCountry = true;
                        break;
                    }
                }
                if (!existCountry) System.out.println("Неизвестная страна");
            }
        } while (true);

    }
}
