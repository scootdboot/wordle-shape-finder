package com.wordleshapefinder.utils;

import com.wordleshapefinder.shapeutils.Color;
import com.wordleshapefinder.shapeutils.Row;

public class Scorer {
    // guess will get forced to uppercase, if you don't pass solution in upper case this will not work
    public static Row scoreWord(String guess, char[] solution) throws LengthMismatchException {
        if (guess.length() != solution.length) {
            throw new LengthMismatchException("Guess length and solution length do not match");
        } // this allows us to assume that solution.length == guess.length()

        guess = guess.toUpperCase();
        Color[] rtn = new Color[solution.length];

        // score greens
        for (int charNum = 0; charNum < guess.length(); charNum++) {
            if (guess.charAt(charNum) == solution[charNum]) {
                rtn[charNum] = Color.GREEN;
                solution[charNum] = '\u0000';
            }
        }

        // score yellows
        for (int guessCharNum = 0; guessCharNum < guess.length(); guessCharNum++) { // loop through guess
            for (int solutionCharNum = 0; solutionCharNum < solution.length; solutionCharNum++) { // check if character is in solution
                if (guess.charAt(guessCharNum) == solution[solutionCharNum]) {
                    rtn[guessCharNum] = Color.YELLOW;
                    solution[solutionCharNum] = '\u0000';
                }
            }
        }

        // fill the rest with grays
        for (int i = 0; i < rtn.length; i++) {
            if (rtn[i] == null) {
                rtn[i] = Color.GRAY;
            }
        }

        return new Row(rtn);
    }

    // both will get forced into upper case
    public static Row scoreWord(String guess, String solution) throws LengthMismatchException {
        return scoreWord(guess, solution.toUpperCase().toCharArray());
    }

    public static class LengthMismatchException extends Exception {
        public LengthMismatchException(String m) {
            super(m);
        }
    }
}
