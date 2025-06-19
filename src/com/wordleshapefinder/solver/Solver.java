package com.wordleshapefinder.solver;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.shapeutils.Row;

public interface Solver {
    public void intakeWordList(WordList wordList);

    public Optional<String> findWord(Row row);
}
