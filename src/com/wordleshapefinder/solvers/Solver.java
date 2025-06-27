package com.wordleshapefinder.solvers;

import java.util.Optional;

import com.wordleshapefinder.WordList;
import com.wordleshapefinder.WordList.WordRetrievalException;
import com.wordleshapefinder.shapeutils.Row;
import com.wordleshapefinder.shapeutils.Shape;

/**
 * This is an abstract class for Solvers to ensure that creating a Solver that functions differently
 *  and implementing it is minimally complicated.
 */
public abstract class Solver {
    public abstract void intakeWordList(WordList newWordList);

    public abstract void updateSolutionWord(String newSolutionWord);

    public abstract Optional<String> findWord(Row row) throws WordRetrievalException;

    public Optional<String> findWord(Row row, String solutionWord) throws WordRetrievalException {
        updateSolutionWord(solutionWord);
        return findWord(row);
    }

    public Optional<String[]> findShape(Shape shape) throws WordRetrievalException {
        Row[] shapeRowArray = shape.getRowArray();
        String[] potentialRtn = new String[shapeRowArray.length];
        // loop through each row and add it to the final array if a solution is found
        // and return early if there is no solution for a given row
        for (int rowIndex = 0; rowIndex < shapeRowArray.length; rowIndex++) {
            Optional<String> rowSolution = findWord(shapeRowArray[rowIndex]);
            if (rowSolution.isEmpty()) { return Optional.empty(); }
            potentialRtn[rowIndex] = rowSolution.get();
        }
        return Optional.of(potentialRtn);
    }
}
