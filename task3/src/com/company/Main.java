package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        int v[] = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++) {
            v[i] = input.nextInt();
        }
        moveMinMaxElements(v);
        for (int elem : v) System.out.println(elem);
    }
    public static void moveMinMaxElements(int[] array) {
        moveMin(array);
        moveMax(array);
    }
    private static void moveMin(int[] array) {
        int indexMin = minIndex(array);
        if (indexMin != -1) {
            moveElement(array, indexMin, 0);
        }
    }
    private static void moveMax(int[] array) {
        int indexMax = maxIndex(array);
        if (indexMax != -1) {
            moveElement(array, indexMax, array.length - 1);
        }
    }
    private static int minIndex(int[] array) {
        if (isArrayEmpty(array)) {
            return -1;
        }
        int indexMin = 0;
        int min = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
        }
        return indexMin;
    }
    private static int maxIndex(int[] array) {
        if (isArrayEmpty(array)) {
            return -1;
        }
        int indexMax = 0;
        int max = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        return indexMax;
    }
    private static void moveElement(int[] array, int indexFrom, int indexTo) {
        if (indexFrom <= indexTo) {
            int tmp = array[indexFrom];
            for (int i = indexFrom; i < indexTo; ++i) {
                array[i] = array[i + 1];
            }
            array[indexTo] = tmp;
        } else {
            int tmp = array[indexFrom];
            for (int i = indexFrom; i > indexTo; --i) {
                array[i] = array[i - 1];
            }
            array[indexTo] = tmp;
        }
    }
    private static boolean isArrayEmpty(int[] array) {
        return array == null || array.length == 0;
    }
}
