package Task_02;

public class main {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        Player[][] players = new Player[n][m];
        Player.info();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                players[i][j] = new Player();
                Player.info();
            }
        }
        Player tmp = new Player();
        Player.printCountPlayers();
        Player tmp1 = new Player();
        Player.printCountPlayers();
        for (int i = 0; i < 100; i++) {
            players[0][0].run();
            System.out.println("Тек. стамина игрока: " + players[0][0].getStamina());
        }
        Player.info();
    }
}
