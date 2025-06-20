package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.WordList.WordRetrievalException;
import com.wordleshapefinder.shapeutils.Color;
import com.wordleshapefinder.shapeutils.Row;

public class SlowSolver extends Solver {
    private WordList wordList;
    private String solutionWord;
    private char[] solutionWordArray;

    /**
     * 
     * @param wordList
     */
    public SlowSolver(WordList wordList) {
        intakeWordList(wordList);
    }

    /**
     * Updates the WordList for the solver to use
     * @param newWordList
     */
    public void intakeWordList(WordList newWordList) {
        wordList = newWordList;
    }

    public void updateSolutionWord(String newSolutionWord) {
        solutionWord = newSolutionWord;
        solutionWordArray = solutionWord.toCharArray();
    }

    /**
     * 
     * @param row
     * @return 
     */
    public Optional<String> findWord(Row row) throws WordRetrievalException {
        Color[] colorArray = row.asArray();
        int wordCount = wordList.getListLength();

        for (int wordNum = 0; wordNum < wordCount; wordNum++) {
            String currentWord = wordList.getWord(wordNum);
            // if the row is not the same length as the word, it is not possible for this to be the solution
            if (colorArray.length != currentWord.length()) {
                continue;
            }
            // check for shape grays that are word greens
            boolean invalidGrays = false;
            for (int charNum = 0; charNum < currentWord.length(); charNum++) {
                // if gray color desired and current matches solution, invalid current word
                if (colorArray[charNum] == Color.GRAY && currentWord.charAt(charNum) == solutionWordArray[charNum]) {
                    invalidGrays = true;
                }
            }
            // if there are intended grays where there are verifiable greens we can skip the rest of this word
            if (invalidGrays) { continue; }

            // we will now score this word as normal
            char[] solutionWordArrayClone = solutionWordArray.clone();
            Color[] score = new Color[currentWord.length()];
            // check and remove greens
            for (int charNum = 0; charNum < currentWord.length(); charNum++) {
                
            }
        }
    }
}
