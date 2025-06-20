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

    public ArrayList<String> extractWords(String fileName) throws Exception {
        // this can throw an exception if the fileName is wrong
        fileReader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> words = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            words.add(line.toUpperCase());
        }

        fileReader.close();
        return words;
    }

    public String getWord(int index) throws WordRetrievalException {
        if (m_words.isEmpty()) {
            throw new WordRetrievalException("No valid word list found");
        }

        try {
            return m_words.get().get(index);
        } catch (Exception e) {
            throw new WordRetrievalException("Failed to retrieve given index from word list");
        }
    }

    public int getListLength() throws WordRetrievalException {
        if (m_words.isEmpty()) {
            throw new WordRetrievalException("No valid word list found");
        }
        return m_words.get().size();
    }

    public static class WordRetrievalException extends Exception {
        public WordRetrievalException(String m) {
            super(m);
        }
    }
}
