package com.wordleshapefinder;

import java.util.Set;

import com.wordleshapefinder.shapeutils.Row;
import com.wordleshapefinder.shapeutils.Shape;
import com.wordleshapefinder.utils.Scorer;

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

        String guess = "DIALS";
        String solution = "PLAIN";
        Row score = Scorer.scoreWord(guess, solution);
        System.out.println("jflkjdfa");
    }
}
