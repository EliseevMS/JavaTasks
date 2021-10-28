package com.company;

public class ChessFigurePosition {
    private int xIndex;
    private int yIndex;

    public static final int BOARD_SIZE = 8;

    private static final String xIndexMapping = "abcdefgh";

    public ChessFigurePosition(int xIndex, int yIndex) {
        setX(xIndex);
        setY(yIndex);
    }

    public ChessFigurePosition(String position) {
        setPosition(position);
    }

    public int getX() {
        return xIndex;
    }

    public int getY() {
        return yIndex;
    }

    public void setX(int xIndex) {
        if (!isIndexValid(xIndex)) {
            throw new IllegalArgumentException(xIndexOutOfBoundsErrorMessage(xIndex));
        }
        this.xIndex = xIndex;
    }

    public void setY(int yIndex) {
        if (!isIndexValid(yIndex)) {
            throw new IllegalArgumentException(yIndexOutOfBoundsErrorMessage(yIndex));
        }
        this.yIndex = yIndex;
    }

    public void setPosition(String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("Invalid position: '" + position + "'. It must be exactly 2 characters long.");
        }

        char xChar = position.charAt(0);
        int xIndex = xIndexMapping.indexOf(xChar);
        if (xIndex != -1) {
            this.xIndex = xIndex;
        } else {
            throw new IllegalArgumentException("Invalid position: '" + position + "'. First character must be symbol between 'a' and 'h'.");
        }


        char yChar = position.charAt(1);
        int yIndex = Character.getNumericValue(yChar) - 1;
        if (Character.isDigit(yChar) && yIndex < BOARD_SIZE) {
            this.yIndex = yIndex;
        } else {
            throw new IllegalArgumentException("Invalid position: '" + position + "'. Second character must be number between 0 and " + (BOARD_SIZE - 1) + ".");
        }
    }

    private boolean isIndexValid(int n) {
        return n >= 0 && n < BOARD_SIZE;
    }

    private String xIndexOutOfBoundsErrorMessage(int n) {
        return "Index X = " + n + " is invalid. It must be number between 0 and " + (BOARD_SIZE - 1) + ".";
    }

    private String yIndexOutOfBoundsErrorMessage(int n) {
        return "Index Y = " + n + " is invalid. It must be number between 0 and " + (BOARD_SIZE - 1) + ".";
    }

    public String toString() {
        return Character.toString(xIndexMapping.charAt(xIndex)) + (yIndex + 1);
    }
}