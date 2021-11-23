package com.company;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("кол-во потоков (<= 26)");
        int n = scanner.nextInt();
        int step = 26 / n;
        Thread[] masT = new Thread[n];
        for (int i = 0; i < n; i++)
            masT[i] = new Thread(new BruteForceRunnable(step * i));
        for (int i = 0; i < n; i++) // запуск потоков
            masT[i].start();
    }
}
