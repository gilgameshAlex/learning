import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BoardItem[][] items1 = new BoardItem[10][10];
        Board board1 = new Board(items1);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Начнем расставлять корабли на поле Player 1. Другой игрок, не смотри!");
        for (Ship ship : board1.getShips()) {
            StringBuilder formatStr = new StringBuilder("");
            int shipCount = ship.getCount();
            int shipSize = ship.getSize();
            for (int i = 0; i < shipSize; i++) {
                if (i + 1 == shipSize) {
                    formatStr.append("x,y");
                }
                else
                {
                    formatStr.append("x,y;");
                }
            }
            for (int i = 0; i < shipCount; i++) {
                board1.print();
                System.out.println(new StringBuilder("Введите координаты ").append(i + 1).append("-го ")
                        .append(ship.getDesc()).append(" корабля (формат: ").append(formatStr).append(")"));
                String input = scanner.nextLine();
                String[] inputSplit = input.split(";");
                //System.out.println(Arrays.toString(inputSplit));
                Arrays.sort(inputSplit);
                //System.out.println(Arrays.toString(inputSplit));
                String[] splitStart = inputSplit[0].split(",");
                String[] splitEnd = inputSplit[inputSplit.length - 1].split(",");
                int sX = Integer.parseInt(splitStart[0]);
                int sY = Integer.parseInt(splitStart[1]);
                int eX = Integer.parseInt(splitEnd[0]);
                int eY = Integer.parseInt(splitEnd[1]);
                if (ship.getSize() > 1) {
                    if ((sX == eX && eY - sY + 1 != ship.getSize()) ||
                            (sY == eY && eX - sX + 1 != ship.getSize())) {
                        i--;
                        System.out.println("Не корректная последовательность координат для текущего корабля");
                        continue;
                    }
                }
                if (inputSplit.length != ship.getSize()) {
                    i--;
                    System.out.println("Не корректное кол-во координат для текущего корабля");
                    continue;
                }
                boolean itemError = false;
                for (String itemPos : inputSplit) {
                    String[] posSplit = itemPos.split(",");
                    if (posSplit.length != 2) {
                        System.out.println("Не корректное кол-во координат");
                        i--;
                        itemError = true;
                        break;
                    }
                    int x = Integer.parseInt(posSplit[0]);
                    int y = Integer.parseInt(posSplit[1]);

                    if (x < 0 || x > 9 || y < 0 || y > 9) {
                        System.out.println("Не корректное значение в координатах < 0 или > 9");
                        i--;
                        itemError = true;
                        break;
                    }

                    if (items1[x][y].name().equals(BoardItem.SHIP_PART.name()) || items1[x][y].name().equals(BoardItem.HALO_PART.name())) {
                        System.out.printf("На указанной позиции {%d,%d} уже находится корабль или зона близ корабля\n", x, y);
                        i--;
                        itemError = true;
                        break;
                    }

                    //Если все проверки пройдены добавляем часть корабля на доску
                    items1[x][y] = BoardItem.SHIP_PART;

                }
                //board1.drawHaloAroundShip(inputSplit[0], inputSplit[inputSplit.length - 1]);

                if (!itemError) {
                    board1.drawHaloAroundShip(sX, sY, eX, eY);
                }
            }
        }

        board1.print();
        /*items1[0][0] = BoardItem.SHIP_PART;
        items1[0][1] = BoardItem.HALO_PART;
        items1[0][2] = BoardItem.INJURED_PART;
        items1[0][3] = BoardItem.MISSING_SHOT;
        board1.print();*/
        board1.shot(0,0);
        board1.shot(0,1);
        board1.shot(0,2);
        board1.print();
        if (board1.getCurCountShip() == 0) {
            System.out.println("Игрок n выиграл!");
        }
        final String u1 = "Player 1";
        final String u2 = "Player 2";
        String curPlayer;
        Random random = new Random();
        switch (random.nextInt(2)) {
            
        }

    }
}
