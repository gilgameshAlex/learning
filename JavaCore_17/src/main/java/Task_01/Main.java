package Task_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1 вариант
        List<ChessPiece> list = new ArrayList<>();
        list.add(ChessPiece.PAWN_WHITE);
        list.add(ChessPiece.PAWN_WHITE);
        list.add(ChessPiece.PAWN_WHITE);
        list.add(ChessPiece.PAWN_WHITE);
        list.add(ChessPiece.ROOK_BLACK);
        list.add(ChessPiece.ROOK_BLACK);
        list.add(ChessPiece.ROOK_BLACK);
        list.add(ChessPiece.ROOK_BLACK);
        System.out.println(list);
        //1.5 вариант
        for (ChessPiece piece : list) {
            System.out.printf(piece + " ");
        }
        System.out.printf("\n");
        //2 вариант
        int n = 8;
        ChessPiece[] chessPieces = new ChessPiece[n];
        for (int i = 0; i < 4; i++) {
            chessPieces[i] = ChessPiece.PAWN_WHITE;
        }
        for (int i = 4; i < 8; i++) {
            chessPieces[i] = ChessPiece.ROOK_BLACK;
        }
        for (int i = 0; i < 8; i++) {
            System.out.printf(chessPieces[i] + " ");
        }
    }
}
