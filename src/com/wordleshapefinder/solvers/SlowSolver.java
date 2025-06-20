package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.WordList.WordRetrievalException;
import com.wordleshapefinder.shapeutils.Color;
import com.wordleshapefinder.shapeutils.Row;
import com.wordleshapefinder.utils.ArrayUtilities;

public class SlowSolver extends Solver {
    private WordList wordList;
    private String solutionWord;
    private char[] solutionWordArray;

    /**
     * 
     * @param wordList
     */
    public SlowSolver(WordList wordList, String solutionWord) {
        intakeWordList(wordList);
        updateSolutionWord(solutionWord);
    }

    /**
     * Updates the WordList for the solver to use
     * @param newWordList New WordList object for the solver to use
     */
    public void intakeWordList(WordList newWordList) {
        wordList = newWordList;
    }

    public void updateSolutionWord(String newSolutionWord) {
        solutionWord = newSolutionWord;
        solutionWordArray = solutionWord.toCharArray();
    }

    /**
     * This method finds a solution that fits the given Row from the previously given WordList using 
     *  the previously given solution word
     * 
     * @param row
     * @return 
     */
    public Optional<String> findWord(Row row) throws WordRetrievalException {
        Color[] colorArray = row.asArray();
        if (solutionWord == null) {
            throw new WordRetrievalException("null solution word");
        }
        if (colorArray.length != solutionWord.length()) {
            // there is literally no way for a solution to be found but i'm not sure
            // if this should be an error or handled properly
            return Optional.empty();
        }
        int wordCount = wordList.getListLength();

        for (int wordNum = 0; wordNum < wordCount; wordNum++) {
            String currentWord = wordList.getWord(wordNum);
            // if the row is not the same length as the word, it is not possible for this to be the solution
            if (colorArray.length != currentWord.length()) {
                continue;
            }
            if (solutionWord.length() != colorArray.length) {
                continue;
            }
            
            boolean mismatch = false; // this flag should go true when a mismatch occurs and early return
            char[] solutionClone = solutionWordArray.clone();
            // -- SCORE GREENS --
            for (int charNum = 0; charNum < colorArray.length; charNum++) {
                // we only want to handle greens at this part, if something isn't a green just go to the next char
                if (colorArray[charNum] != Color.GREEN) {
                    continue;
                }

                char currentChar = currentWord.charAt(charNum);
                if (currentChar == solutionClone[charNum]) {
                    solutionClone[charNum] = ' ';
                } else {
                    mismatch = true;
                    break;
                }
            }
            // if mismatch, don't check this word further, go to next word
            if (mismatch) { continue; }

            // -- SCORE YELLOWS --
            for (int charNum = 0; charNum < colorArray.length; charNum++) {
                if (colorArray[charNum] != Color.YELLOW) {
                    continue;
                }

                char currentChar = currentWord.charAt(charNum);
                // only if both of these are true we should qualify this as properly scoring yellow
                if (currentChar != solutionClone[charNum] && ArrayUtilities.charArrayContains(solutionClone, currentChar)) {
                    solutionClone[ArrayUtilities.getFirstOccuranceIndex(solutionClone, currentChar)] = ' ';
                } else {
                    mismatch = true;
                    break;
                }
            }
            if (mismatch) { continue; }

            // -- SCORE GRAYS --
            for (int charNum = 0; charNum < colorArray.length; charNum++) {
                if (colorArray[charNum] != Color.GRAY) {
                    continue;
                }

                char currentChar = currentWord.charAt(charNum);
                // as long as it's not in the solutionClone, it has to be gray
                if (!ArrayUtilities.charArrayContains(solutionClone, currentChar)) {
                    // nothing specific has to happen here
                } else {
                    mismatch = true;
                    break;
                }
            }
            if (mismatch) { continue; }

            // if we get all the way here, the currentWord is a solution
            return Optional.of(currentWord);
        }

        // if we get out of this for loop, there is no solution
        return Optional.empty();
    }
}
