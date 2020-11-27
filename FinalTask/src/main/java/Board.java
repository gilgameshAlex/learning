import java.util.ArrayList;
import java.util.List;

public class Board {
    BoardItem[][] items;
    private List<Ship> ships;
    private int curCountShip;

    public int getCurCountShip() {
        return curCountShip;
    }

    public Board() {
        ships = new ArrayList<>();
        ships.add(Ship.SHIP_1);
        ships.add(Ship.SHIP_2);
        ships.add(Ship.SHIP_3);
        ships.add(Ship.SHIP_4);
        this.curCountShip = 0;
        for (Ship ship : ships) {
            this.curCountShip += ship.getCount();
        }
    }

    public Board(BoardItem[][] items) {
        this.items = items;
        ships = new ArrayList<>();
        //ships.add(Ship.SHIP_1);
        //ships.add(Ship.SHIP_2);
        ships.add(Ship.SHIP_3);
        //ships.add(Ship.SHIP_4);
        for (int i = 0; i < this.items.length; i++) {
            for (int j = 0; j < this.items[i].length; j++) {
                if (this.items[i][j] == null) {
                    this.items[i][j] = BoardItem.EMPTY;
                    this.items[i][j].setPosition(i, j);
                }
            }
        }
        this.curCountShip = 0;
        for (Ship ship : ships) {
            this.curCountShip += ship.getCount();
        }
    }

    public void setItems(BoardItem[][] items) {
        this.items = items;
    }

    public List<Ship> getShips() {
        return ships;
    }

    //public void drawHaloAroundShip (String start, String end) {
    public void drawHaloAroundShip (int sX, int sY, int eX, int eY) {
        /*String[] splitStart = start.split(",");
        String[] splitEnd = end.split(",");
        int sX = Integer.parseInt(splitStart[0]);
        int sY = Integer.parseInt(splitStart[1]);
        int eX = Integer.parseInt(splitEnd[0]);
        int eY = Integer.parseInt(splitEnd[1]);*/
        //
        int startX = sX;
        int startY = sY;
        int endX = eX;
        int endY = eY;
        //Vertical
        /*if ((sX == eX && sY != eY && sY > eY) ||
                (sX != eX && sY == eY && sX > eX)) {
            startX = eX;
            startY = eY;
            endX = sX;
            endY = sY;
        }*/
        //Horisontal
        /*if (sX != eX && sY == eY) {

        }*/
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
    /*
     * Функция выстрела
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
            System.out.println("Мимо!");
        }
        return false;
    }

    /*
     * Функции проверки затопления корабля
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

    public void print() {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                System.out.printf(this.items[i][j].toString());
            }
            System.out.printf("\n");
        }
    }

}
