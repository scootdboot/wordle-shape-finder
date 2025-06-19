package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.shapeutils.Row;

public class SlowSolver extends Solver {
    private WordList wordList;

    public SlowSolver(WordList wordList) {
        intakeWordList(wordList);
    }

    public void intakeWordList(WordList newWordList) {
        wordList = newWordList;
    }

    public Optional<String> findWord(Row row) {
        
    }
}
