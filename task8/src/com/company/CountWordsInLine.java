package com.company;

public class CountWordsInLine {
    public static void main(String[] args) {
        testCountWordsInLine();
    }

    public static long countWordsInLine(String line) {
        if (line == null || line.trim().length() == 0) {
            return 0;
        }
        String[] words = line.trim().split("\\s+");
        return words.length;
    }

    private static void testCountWordsInLine() {
        String[] lines = {
                "",
                "  ",
                "\n",
                "\r\n",
                "\r",
                "one",
                " one two   three  ",
        };
        for (String line : lines) {
            System.out.println("\"" + line + "\": " + countWordsInLine(line));
        }
    }
}