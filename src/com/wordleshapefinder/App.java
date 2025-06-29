package com.wordleshapefinder;

import java.util.Optional;
import java.util.Set;

import com.wordleshapefinder.shapeutils.Row;
import com.wordleshapefinder.shapeutils.Shape;
import com.wordleshapefinder.utils.Scorer;
import com.wordleshapefinder.solvers.ScorerSolver;
import com.wordleshapefinder.solvers.SlowSolver;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(Color.fromText("⬛️").isPresent());
        // System.out.println(Color.fromText("⬛️").get().textRepresentation);

        // WordList wordList = new WordList("Words.txt");
        // System.out.println(wordList.getWord(0));
        // System.out.println(wordList.getWord(4999));
        // System.out.println(wordList.getWord(14853));

        // String shapeString = "_G_Y_\nGGG__\nGGG__\nGGG_Y\nGGGGG\n_____";
        // Shape shape = new Shape(shapeString);
        // Row[] rowArray = shape.getRowArray();
        // Set<Row> optimizedSet = shape.getOptimizedSet();
        // System.out.println();

        WordList wordList = new WordList("Words.txt");
        // System.out.println(wordList.getWord(0));
        // System.out.println(wordList.getWord(4999));
        // System.out.println(wordList.getWord(14853));

        String shapeString = "YYYYY\nY_Y_Y\nY_Y_Y\nYYYYY\nGGGGG";
        Shape shape = new Shape(shapeString);
        ScorerSolver scorerSolver = new ScorerSolver(wordList, "PLAIN");
        Optional<String[]> correctlyScoringWordArrayOptional = scorerSolver.findShape(shape);
        if (correctlyScoringWordArrayOptional.isPresent()) {
            String[] correctlyScoringWordArray = correctlyScoringWordArrayOptional.get();
            for (int i = 0; i < correctlyScoringWordArray.length; i++) {
                System.out.println(correctlyScoringWordArray[i]);
            }
        } else {
            System.out.println("no available shape");
        }
    }
}
