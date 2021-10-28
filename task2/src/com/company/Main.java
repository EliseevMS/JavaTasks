package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("количество байт: ");
        long sizeInBytes = in.nextLong();
            System.out.println(sizeInBytes + " B -> " + formatBytes(sizeInBytes));
        }
    public static String formatBytes(long sizeInBytes) {
        String[] units = new String[] {"B","KB","MB","GB","TB"};
        int unitNumber  = 0;
        float sizeInUnits = sizeInBytes;
        while (sizeInUnits >= 1024) {
            sizeInUnits /= 1024;
            unitNumber++;
        }
        return String.format("%.1f",sizeInUnits) + " " + units[unitNumber];
        }
    }
