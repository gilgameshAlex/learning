package Task_02;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int m = 8;
        ChessPiece[][] pieces = new ChessPiece[n][m];
        pieces[0][0] = ChessPiece.ROOK_BLACK;
        pieces[0][5] = ChessPiece.ROOK_BLACK;
        pieces[0][6] = ChessPiece.KING_BLACK;
        pieces[1][1] = ChessPiece.ROOK_WHITE;
        pieces[1][4] = ChessPiece.PAWN_BLACK;
        pieces[1][5] = ChessPiece.PAWN_BLACK;
        pieces[1][7] = ChessPiece.PAWN_BLACK;
        pieces[2][0] = ChessPiece.PAWN_BLACK;
        pieces[2][2] = ChessPiece.KNIGHT_BLACK;
        pieces[2][6] = ChessPiece.PAWN_BLACK;
        pieces[3][0] = ChessPiece.QUEEN_BLACK;
        pieces[3][3] = ChessPiece.BISHOP_WHITE;
        pieces[4][3] = ChessPiece.BISHOP_BLACK;
        pieces[4][4] = ChessPiece.PAWN_WHITE;
        pieces[5][4] = ChessPiece.BISHOP_WHITE;
        pieces[5][5] = ChessPiece.PAWN_WHITE;
        pieces[6][0] = ChessPiece.PAWN_WHITE;
        pieces[6][3] = ChessPiece.QUEEN_WHITE;
        pieces[6][5] = ChessPiece.PAWN_WHITE;
        pieces[6][7] = ChessPiece.PAWN_WHITE;
        pieces[7][5] = ChessPiece.ROOK_WHITE;
        pieces[7][6] = ChessPiece.KING_WHITE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pieces[i][j] == null)
                    pieces[i][j] = ChessPiece.EMPTY;
            }
        }

        ChessBoard board = new ChessBoard(pieces);
        board.print();
    }
}
