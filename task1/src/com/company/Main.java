package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите координату х вершины №1: ");
        int x1 = in.nextInt();
        System.out.print("Введите координату х вершины №2: ");
        int x2 = in.nextInt();
        System.out.print("Введите координату х вершины №3: ");
        int x3 = in.nextInt();
        System.out.print("Введите координату y вершины №1: ");
        int y1 = in.nextInt();
        System.out.print("Введите координату y вершины №2: ");
        int y2 = in.nextInt();
        System.out.print("Введите координату y вершины №3: ");
        int y3 = in.nextInt();
        in.close();
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (a + b <= c || a + c <= b || b + c <= a)
            System.out.println("Треугольник не существует");
        else
        {
            double p = (a + b + c) / 2.0;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Площадь: " + square);
        }
    }
}
