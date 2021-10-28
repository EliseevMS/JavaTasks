package com.company;
import com.company.ChessFigurePosition;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        String[] strPositions_1 = new String[]{"b1", "a3", "c4", "d6"};
        String[] strPositions_2 = new String[]{"g8", "e7", "e6"};
        String[] strPositions_3 = new String[]{"g8", "e7", "c8"};

        test(strPositions_1);
        test(strPositions_2);
        test(strPositions_3);
    }

    private static void test(String[] strPositions) {
        System.out.println("[in]  " + Arrays.toString(strPositions));

        ChessFigurePosition[] positions = new ChessFigurePosition[strPositions.length];
        for (int i = 0; i < strPositions.length; i++) {
            positions[i] = new ChessFigurePosition(strPositions[i]);
        }

        System.out.print("[out] ");

        try {
            ChessKnight.makeMoves(positions);
            System.out.println("OK");
        } catch (IllegalMoveException e) {
            System.out.println(e);
        }

        System.out.println();
    }
}
