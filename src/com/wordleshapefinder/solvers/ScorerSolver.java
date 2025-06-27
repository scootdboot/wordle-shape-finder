package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.WordList.WordRetrievalException;
import com.wordleshapefinder.shapeutils.Row;
import com.wordleshapefinder.utils.Scorer;
import com.wordleshapefinder.utils.Scorer.LengthMismatchException;

public class ScorerSolver extends Solver {
    WordList wordList;
    String solutionWord;

    public ScorerSolver(WordList newWordList, String newSolutionWord) {
        intakeWordList(newWordList);
        updateSolutionWord(newSolutionWord);
    }

    @Override
    public void intakeWordList(WordList newWordList) {
        wordList = newWordList;
    }

    @Override
    public void updateSolutionWord(String newSolutionWord) {
        solutionWord = newSolutionWord;
    }

    @Override
    public Optional<String> findWord(Row row) throws WordRetrievalException {
        if (wordList == null) {
            throw new WordRetrievalException("No wordList present");
        }
        if (solutionWord == null) {
            throw new WordRetrievalException("Null solution word");
        }

        for (int i = 0; i < wordList.getListLength(); i++) {
            Row scoredWord;
            String guess = wordList.getWord(i).toUpperCase();
            try {
                scoredWord = Scorer.scoreWord(guess, solutionWord.toUpperCase());
            } catch (LengthMismatchException e) {
                continue;
            }

            if (row.equals(scoredWord)) {
                return Optional.of(guess);
            }
        }

        return Optional.empty();
    }
    
}
