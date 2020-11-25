package Task_02;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public void print() {
        int length = this.board.length;
        for (int i = 0; i < length; i++) {
            int length2 = board[i].length;
            for (int j = 0; j < length2; j++) {
                System.out.printf(board[i][j].toString());
            }
            System.out.printf("\n");
        }
    }
}
