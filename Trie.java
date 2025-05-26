package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Trie (prefix tree) implementation for storing words and their occurrences
 * in documents. Each word in the trie is associated with a list of occurrences
 * that store information such as the filename, page index, and position.
 */
public class Trie {

    /**
     * Inner class representing a single node in the Trie.
     */
    private class TrieNode {
        TrieNode[] children; // Array to store child nodes (one for each letter in the alphabet)
        List<Occurrence> occurrences; // List to store occurrences of the word ending at this node

        /**
         * Constructor to initialize the TrieNode with 26 children (for 'a' to 'z') and an empty list of occurrences.
         */
        public TrieNode() {
            this.children = new TrieNode[26]; // 26 letters in the alphabet
            this.occurrences = new ArrayList<>();
        }

        /**
         * Converts a character to an index between 0 and 25 based on its position in the alphabet.
         *
         * @param c The character to convert.
         * @return The index corresponding to the character.
         */
        public int charToIndex(char c) {
            return c - 'a';
        }
    }

    private TrieNode root; // Root node of the Trie

    /**
     * Constructor to initialize the Trie with an empty root node.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the Trie along with its occurrence details.
     *
     * @param word      The word to insert into the Trie.
     * @param filename  The name of the file where the word was found.
     * @param pageIndex The page index where the word was found.
     * @param position  The position of the word within the page.
     */
    public void insert(String word, String filename, int pageIndex, int position) {
        TrieNode node = root;

        // Traverse through each character in the word
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) { // Ignore non-letter characters
                c = Character.toLowerCase(c); // Convert to lowercase for case-insensitivity
                int index = node.charToIndex(c);

                // Create a new TrieNode if none exists for the current character
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                // Move to the next node in the Trie
                node = node.children[index];
            }
        }

        // Add the occurrence details at the last node
        node.occurrences.add(new Occurrence(pageIndex, position, filename));
    }

    /**
     * Searches for a word in the Trie and returns a list of occurrences if found.
     *
     * @param word The word to search for in the Trie.
     * @return A list of occurrences of the word, or an empty list if the word is not found.
     */
    public List<Occurrence> search(String word) {
        TrieNode node = root;

        // Traverse through each character in the word
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) { // Ignore non-letter characters
                c = Character.toLowerCase(c); // Convert to lowercase for case-insensitivity
                int index = node.charToIndex(c);

                // If the node for the current character does not exist, the word is not found
                if (node.children[index] == null) {
                    return Collections.emptyList(); // Return an empty list
                }

                // Move to the next node in the Trie
                node = node.children[index];
            }
        }

        // Return the list of occurrences stored at the last node
        return node.occurrences;
    }
}
