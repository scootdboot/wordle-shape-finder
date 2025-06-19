package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.shapeutils.Row;

/**
 * This is an interface for Solvers to ensure that creating a Solver that functions differently
 *  and implementing it is minimally complicated.
 */
public interface Solver {
    public void intakeWordList(WordList wordList);

    public Optional<String> findWord(Row row);
}
