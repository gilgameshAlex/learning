import logic.Board;
import logic.BoardItem;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Board board1 = new Board();
        System.out.println("Начнем расставлять корабли на поле Player 1. Другой игрок, не смотри!");
        board1.fillBoard();
        board1.print();
        printCls();
        Board board2 = new Board();
        System.out.println("Начнем расставлять корабли на поле Player 2. Другой игрок, не смотри!");
        board2.fillBoard();
        board2.print();
        printCls();

        final String u1 = "Player 1";
        final String u2 = "Player 2";
        String curPlayerName;
        int curPlayerIndex;
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                curPlayerName = u1;
                curPlayerIndex = 0;
                break;
            case 1:
                curPlayerName = u2;
                curPlayerIndex = 1;
                break;
            default:
                curPlayerName = "unknown";
                curPlayerIndex = -1;
        }

        printCls();
        System.out.println("Первым ходит " + curPlayerName);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (board1.getCurCountShip() == 0) {
                System.out.println("Игрок " + u2 + " выиграл!");
                return;
            }
            if (board2.getCurCountShip() == 0) {
                System.out.println("Игрок " + u1 + " выиграл!");
                return;
            }
            System.out.println(curPlayerName + " вводи координаты для выстрела (x y)");
            try {
                switch (curPlayerIndex) {
                    case 0:
                        board2.printEnemy();
                        if (!board2.shot(scanner.nextInt(), scanner.nextInt())) {
                            curPlayerIndex = 1;
                            curPlayerName = u2;
                            printCls();
                        }
                        break;
                    case 1:
                        board1.printEnemy();
                        if (!board1.shot(scanner.nextInt(), scanner.nextInt())) {
                            curPlayerIndex = 0;
                            curPlayerName = u1;
                            printCls();
                        }
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(curPlayerName + " введи корректные координаты выстрела");
                scanner = new Scanner(System.in);
            }
        }
    }

    public static void printCls() {
        for (int i = 0; i < 20; i++) {
            System.out.printf("\n");
        }
    }
}
