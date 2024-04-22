package com.alten.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {3, 1, 5, 4, 5, 4, 78, 2};
        System.out.println(Arrays.toString(ordina(myArray)));
    }
    public static int[] ordina(int[] daOrdinare) {
        for (int i = 0; i < daOrdinare.length; i++) {
            for (int j = 0; j < daOrdinare.length - i - 1; j++) {
                if (daOrdinare[j + 1] < daOrdinare[j]) {
                    int temp = daOrdinare[j + 1];
                    daOrdinare[j + 1] = daOrdinare[j];
                    daOrdinare[j] = temp;
                }
            }
        }
        return daOrdinare;
    }
}
