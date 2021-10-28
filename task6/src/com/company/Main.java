package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.print("Введены некорректные данные!");
            return;
        }
        String[] str = new String[n];

        for (int i=0; i<n; i++) {
            System.out.print("Введите строку номер " + (i+1) + ": ");
            str[i] = scaner.next();
        }
        //for( int i=0; i<n; i++) {
             //int index1=str.length;
             //index1 = str[i].indexOf("/");
             //str[i] = str[i].substring(0,5);
             //System.out.println(str[i]);
        //}
    }
}
