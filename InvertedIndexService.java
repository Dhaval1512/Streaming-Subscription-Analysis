package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.AVLTree;
import com.example.model.Occurrence;
import com.example.model.Trie;

/**
 * Service class for managing an inverted index using a Trie and AVL Tree.
 * The inverted index allows efficient storage and retrieval of word occurrences
 * in text files located in a specific directory.
 */
@Service
public class InvertedIndexService {
    // Trie for storing word occurrences (word -> list of occurrences in files)
    private final Trie trie = new Trie();

    // AVL Tree for efficiently tracking word frequencies
    private final AVLTree avlTree = new AVLTree();

    /**
     * Constructor for the InvertedIndexService. 
     * Initializes the inverted index upon service creation.
     */
    public InvertedIndexService() {
        initializeInvertedIndex();
    }

    /**
     * Initializes the inverted index by reading text files from the "text_pages" directory.
     * Each word is processed and added to both the Trie and the AVL Tree.
     */
    private void initializeInvertedIndex() {
        // Specify the directory containing text files
        File dir = new File("src/main/text_pages"); // Use relative path based on the app root

        // Check if the directory exists and is accessible
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Directory 'text_pages' does not exist or is not accessible.");
            return; // Exit if the directory is invalid
        }

        // Filter to only include .txt files
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.err.println("No .txt files found in the 'text_pages' directory.");
            return; // Exit if no .txt files are found
        }

        // Iterate through each file and process its content
        for (int pageIndex = 0; pageIndex < files.length; pageIndex++) {
            File file = files[pageIndex];
            try {
                // Read the content of the file
                String content = readFile(file.getAbsolutePath());
                // Split the content into words using non-word characters as delimiters
                String[] words = content.split("\\W+");

                // Add each word to the Trie and AVL Tree
                for (int position = 0; position < words.length; position++) {
                    String word = words[position].toLowerCase(); // Normalize word to lowercase
                    if (!word.isEmpty()) { // Ignore empty words
                        // Insert word with its occurrence details into the Trie
                        trie.insert(word, file.getName(), pageIndex + 1, position);
                        // Insert word into the AVL Tree for frequency tracking
                        avlTree.insert(word);
                    }
                }
            } catch (IOException e) {
                // Handle errors that occur while reading the file
                System.err.println("Error reading file: " + file.getName());
                e.printStackTrace();
            }
        }
    }

    /**
     * Reads the content of a file and returns it as a single string.
     *
     * @param filePath the path to the file
     * @return the content of the file
     * @throws IOException if an error occurs while reading the file
     */
    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line and append it to the content string
            while ((line = br.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }

    /**
     * Searches for occurrences of a word in the inverted index.
     *
     * @param word the word to search for
     * @return a list of occurrences of the word in the indexed files
     */
    public List<Occurrence> searchInvertedIndex(String word) {
        return trie.search(word);
    }

    /**
     * Retrieves the frequency of a word from the AVL Tree.
     *
     * @param word the word whose frequency is to be retrieved
     * @return the frequency of the word
     */
    public int getFrequency(String word) {
        return avlTree.getFrequency(word);
    }
}
