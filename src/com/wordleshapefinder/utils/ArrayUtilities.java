package com.wordleshapefinder.utils;

public class ArrayUtilities {
    public static boolean charArrayContains(char[] array, char c) {
        for (char iter : array) {
            if (iter == c) { return true; }
        }
        return false;
    }
}
