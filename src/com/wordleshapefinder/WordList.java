package com.wordleshapefinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

public class WordList {
    private BufferedReader fileReader;
    private Optional<ArrayList<String>> m_words = Optional.empty();

    public WordList(String fileName) {
        try {
            m_words = Optional.of(extractWords(fileName));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        try {
            if (fileReader != null) {
                fileReader.close();
            }
        } catch (Exception e) {
            System.out.println("failed to close fileReader");
        }
    }

    private ArrayList<String> extractWords(String fileName) throws Exception {
        // this can throw an exception if the fileName is wrong
        fileReader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> words = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            words.add(line);
        }

        fileReader.close();
        return words;
    }

    public Optional<ArrayList<String>> getWords() {
        return m_words;
    }
}
