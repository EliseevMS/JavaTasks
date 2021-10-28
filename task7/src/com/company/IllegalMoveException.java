package com.company;

import com.company.ChessFigurePosition;

public class IllegalMoveException extends Exception {
    public final ChessFigurePosition start;
    public final ChessFigurePosition end;

    public IllegalMoveException(ChessFigurePosition start, ChessFigurePosition end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Incorrect move for chess knight: " + start + " -> " + end;
    }
}