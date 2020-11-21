package Task_02;

import java.util.Random;

public class Player {
    private int stamina;
    public final static int MIN_STAMINA = 0;
    public final static int MAX_STAMINA = 100;
    private static int countPlayers = 0;
    private final static int MAX_COUNT_PLAYER = 6;
    public Player() {
        Random random = new Random();
        this.stamina = random.nextInt(10) + 90;
        if (countPlayers + 1 <= MAX_COUNT_PLAYER)
            countPlayers++;
        else System.out.println("Достигнут предел кол-ва игроков - " + countPlayers);
    }

    public static void info() {
        if (countPlayers < 6) System.out.println("Команды неполные. На поле еще есть " + (MAX_COUNT_PLAYER - countPlayers) + " " + getRussianGrammar(MAX_COUNT_PLAYER - countPlayers));
        else System.out.println("На поле нет свободных мест.");
    }

    public static void printCountPlayers() {
        System.out.println("Кол-во игроков на поле: " + countPlayers);
    }

    public void run() {
        if (this.stamina - 1 < 0) return;
        this.stamina--;
        if (this.stamina == 0) countPlayers--;
    }

    public int getStamina() {
        return this.stamina;
    }

    private static String getRussianGrammar(int count)
    {
        String res = "";
        if (count == 1) {
            res = "свободное место"; return res;
        }
        res = "свободных";
        switch (count)
        {
            case 0:
            case 5:
            case 6:
                res += " мест";
                break;
            case 2:
            case 3:
            case 4:
                res += " места";
                break;
        }
        return res;
    }
}
