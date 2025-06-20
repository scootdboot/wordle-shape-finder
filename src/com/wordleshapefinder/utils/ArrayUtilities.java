package com.wordleshapefinder.utils;

public class ArrayUtilities {
    public static boolean charArrayContains(char[] array, char c) {
        for (char iter : array) {
            if (iter == c) { return true; }
        }
        return false;
    }

    public static int getFirstOccuranceIndex(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) { return i; }
        }
        return -1;
    }
}
