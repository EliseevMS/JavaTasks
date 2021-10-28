package com.company;

import com.company.ChessFigurePosition;
import com.company.IllegalMoveException;

public class ChessKnight {
    public static boolean isMoveCorrect(ChessFigurePosition start, ChessFigurePosition end) {
        return Math.abs(end.getX() - start.getX()) == 1 && Math.abs(end.getY() - start.getY()) == 2
                || Math.abs(end.getX() - start.getX()) == 2 && Math.abs(end.getY() - start.getY()) == 1;
    }

    public static void makeMoves(ChessFigurePosition[] positions) throws IllegalMoveException {
        for (int i = 0; i < positions.length - 1; i++) {
            ChessFigurePosition start = positions[i];
            ChessFigurePosition end = positions[i + 1];
            if (!isMoveCorrect(start, end)) {
                throw new IllegalMoveException(start, end);
            }
        }
    }
}