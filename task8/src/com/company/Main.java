package com.company;

import com.company.CountWordsInLine;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Usage: program expect 1 file path argument");
        }
        String file = args[0];
        System.out.println("There are " + countWordsInFile(file) + " words in file " + file);
    }

    public static long countWordsInFile(String file) {
        long numberOfWords = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = null;
            while((line = in.readLine()) != null) {
                numberOfWords += CountWordsInLine.countWordsInLine(line);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File \"" + file + "\" not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfWords;
    }
}
