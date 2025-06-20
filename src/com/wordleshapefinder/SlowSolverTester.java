package com.wordleshapefinder;

import java.util.Optional;

import com.wordleshapefinder.shapeutils.Shape;
import com.wordleshapefinder.solvers.SlowSolver;

public class SlowSolverTester {
    public static void main(String[] args) throws Exception {
        Shape desiredShape = new Shape("_YYY_\nY_YG_\n_YGGY\nGGGGG");
        WordList testWordList = new WordList("SlowSolverTestWords.txt");
        SlowSolver slowSolver = new SlowSolver(testWordList, "curio");
        Optional<String[]> solutions = slowSolver.findShape(desiredShape);

        System.out.println("END PROGRAM"); // sout for convenient breakpoints to read variables
    }
}
