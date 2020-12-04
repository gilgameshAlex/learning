package logic;

import excp.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board{
    BoardItem[][] items;
    private List<Ship> ships;
    private int curCountShip;
    private static final int n = 10;
    private static final int m = 10;

    public int getCurCountShip() {
        return curCountShip;
    }

    public Board() {
        this.items = new BoardItem[n][m];
        this.fillEmptyBoard();
        this.addShips();
        this.curCountShip = 0;
        for (Ship ship : ships) {
            this.curCountShip += ship.getCount();
        }
    }

    public Board(BoardItem[][] items) {
        this.items = items;
        this.fillEmptyBoard();
        this.addShips();
        this.curCountShip = 0;
        for (Ship ship : ships) {
            this.curCountShip += ship.getCount();
        }
    }

    /**
     * Инициализация начальной доски, пустыми значениями
     */
    private void fillEmptyBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.items[i][j] == null) {
                    this.items[i][j] = BoardItem.EMPTY;
                    this.items[i][j].setPosition(i, j);
                }
            }
        }
    }

    /**
     * Заполнение игрового поля кораблями
     */
    public void fillBoard() {
        Scanner scanner = new Scanner(System.in);
        for (Ship ship : this.ships) {
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
                try {
                    System.out.println(new StringBuilder("Введите координаты ").append(i + 1).append("-го ")
                            .append(ship.getDesc()).append(" корабля (формат: ").append(formatStr).append(")"));
                    String input = scanner.nextLine();
                    String[] inputSplit = input.split(";");
                    Arrays.sort(inputSplit);
                    String[] splitStart = inputSplit[0].split(",");
                    String[] splitEnd = inputSplit[inputSplit.length - 1].split(",");
                    if (splitStart.length != 2 || splitEnd.length != 2) {
                        throw new CustomException("[0] Не корректная последовательность координат для текущего корабля");
                    }
                    int sX = Integer.parseInt(splitStart[0]);
                    int sY = Integer.parseInt(splitStart[1]);
                    int eX = Integer.parseInt(splitEnd[0]);
                    int eY = Integer.parseInt(splitEnd[1]);
                    if (ship.getSize() > 1) {
                        if ((sX == eX && eY - sY + 1 != ship.getSize()) ||
                                (sY == eY && eX - sX + 1 != ship.getSize())) {
                            i--;
                            throw new CustomException("[1] Не корректная последовательность координат для текущего корабля");
                        }
                    }
                    if (inputSplit.length != ship.getSize()) {
                        i--;
                        throw new CustomException("[2] Не корректное кол-во координат для текущего корабля");
                    }
                    boolean itemError = false;
                    for (String itemPos : inputSplit) {
                        String[] posSplit = itemPos.split(",");
                        if (posSplit.length != 2) {
                            i--;
                            itemError = true;
                            throw new CustomException("Не корректное кол-во координат");
                        }
                        int x = Integer.parseInt(posSplit[0]);
                        int y = Integer.parseInt(posSplit[1]);

                        if (x < 0 || x > 9 || y < 0 || y > 9) {
                            i--;
                            itemError = true;
                            throw new CustomException("Не корректное значение в координатах < 0 или > 9");
                        }

                        if (this.items[x][y].name().equals(BoardItem.SHIP_PART.name()) || this.items[x][y].name().equals(BoardItem.HALO_PART.name())) {
                            System.out.printf("На указанной позиции {%d,%d} уже находится корабль или зона близ корабля\n", x, y);
                            i--;
                            itemError = true;
                            break;
                        }

                        //Если все проверки пройдены добавляем часть корабля на доску
                        this.items[x][y] = BoardItem.SHIP_PART;

                    }

                    if (!itemError) {
                        this.drawHaloAroundShip(sX, sY, eX, eY);
                    }
                }
                catch (CustomException e) {}
            }
        }
    }

    /**
     * Добавление списка доступных кораблей для расстановки
     */
    private void addShips()
    {
        ships = new ArrayList<>();
        ships.add(Ship.SHIP_1);
        ships.add(Ship.SHIP_2);
        ships.add(Ship.SHIP_3);
        ships.add(Ship.SHIP_4);
    }

    public void setItems(BoardItem[][] items) {
        this.items = items;
    }

    public List<Ship> getShips() {
        return ships;
    }

    /**
     * Расстановка ореола корабля
     * @param sX - строка начала корабля
     * @param sY - колонка начала корабля
     * @param eX - строка конца корабля
     * @param eY - колонка конца корабля
     */
    private void drawHaloAroundShip (int sX, int sY, int eX, int eY) {
        int startX = sX;
        int startY = sY;
        int endX = eX;
        int endY = eY;
        if (startX - 1 >= 0) {
            startX--;
        }
        if (startY - 1 >= 0) {
            startY--;
        }
        if (endX + 1 < 10) {
            endX++;
        }
        if (endY + 1 < 10) {
            endY++;
        }
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                String curItemName = this.items[i][j].name();
                if (!curItemName.equals(BoardItem.SHIP_PART.name()) && ! curItemName.equals(BoardItem.HALO_PART)) {
                    this.items[i][j] = BoardItem.HALO_PART;
                }
            }
        }
    }

    /**
     * Функция выстрела
     * @param x - строка выстрела
     * @param y - колонка выстрела
     * @return - true если нужно повторить выстре, false - иначе
     */
    public boolean shot(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            System.out.println("Не верные координаты для выстрела, попробуйте еще раз.");
            return true;
        }
        if (this.items[x][y].name().equals(BoardItem.SHIP_PART.name())) {
            this.items[x][y] = BoardItem.INJURED_PART;
            if (!isKillShip(x, y))
                System.out.println("Попадание!");
            else {
                System.out.println("Утопил!");
                this.curCountShip--;
            }
            return true;
        }
        else {
            this.items[x][y] = BoardItem.MISSING_SHOT;
            System.out.println("Мимо!");
        }
        return false;
    }

    /**
     * Проверка, что корабль затоплен
     * @param x - координата попадания по оси X
     * @param y - координата попадания по оси Y
     * @return true если корабль затоплен, false иначе
     */
    private boolean isKillShip(int x, int y) {
        int res = 0;
        res += checkDeathShipRecursive(x + 1, y, "up");
        res += checkDeathShipRecursive(x - 1, y, "down");
        res += checkDeathShipRecursive(x, y + 1, "right");
        res += checkDeathShipRecursive(x, y - 1, "left");
        if (res > 0) {
            return false;
        }
        return true;
    }
    private int checkDeathShipRecursive(int x, int y, String direction) {
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return 0;
        }
        String itemName = items[x][y].name();
        if (itemName.equals(BoardItem.HALO_PART.name()) || itemName.equals(BoardItem.EMPTY.name())) {
            return  0;
        }
        if (itemName.equals(BoardItem.SHIP_PART.name())) {
            return 1;
        }
        else {
            switch (direction) {
                case "up":
                    return checkDeathShipRecursive(x + 1, y, "up");
                case "down":
                    return checkDeathShipRecursive(x - 1, y, "down");
                case "right":
                    return checkDeathShipRecursive(x, y + 1, "right");
                case "left":
                    return checkDeathShipRecursive(x, y - 1, "left");
            }
        }
        return 0;
    }

    /**
     * Печать доски как есть по расстановке
     */
    public void print() {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                System.out.printf(this.items[i][j].toString() + "|");
            }
            System.out.printf("\n");
        }
    }

    /**
     * Печать доски для другого игрока, не отображая части корабля и ореолы
     */
    public void printEnemy() {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                switch (this.items[i][j])
                {
                    case SHIP_PART:
                    case HALO_PART:
                        System.out.printf(BoardItem.EMPTY.toString());
                        break;
                    default:
                        System.out.printf(this.items[i][j].toString());
                }
                System.out.printf("|");
            }
            System.out.printf("\n");
        }
    }
}
