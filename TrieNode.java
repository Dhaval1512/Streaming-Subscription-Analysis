package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single node in a Trie (prefix tree). Each node contains an array of child nodes
 * and a list of occurrences representing where a word ending at this node appears.
 */
public class TrieNode {
    // Array to hold child nodes for each letter (26 letters in the English alphabet)
    TrieNode[] children;
    
    // List of occurrences for words that end at this node
    List<Occurrence> occurrences;

    /**
     * Constructor to initialize a TrieNode.
     * - Initializes the `children` array to hold 26 potential child nodes (for 'a' to 'z').
     * - Initializes an empty list of occurrences.
     */
    public TrieNode() {
        this.children = new TrieNode[26]; // 26 letters in the alphabet
        this.occurrences = new ArrayList<>();
    }

    /**
     * Gets the array of child nodes.
     *
     * @return An array of child TrieNode objects.
     */
    public TrieNode[] getChildren() {
        return children;
    }

    /**
     * Gets the list of occurrences stored in this node.
     *
     * @return A list of `Occurrence` objects.
     */
    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    /**
     * Adds an occurrence to the list of occurrences for the current node.
     *
     * @param occurrence The `Occurrence` object to add.
     */
    public void addOccurrence(Occurrence occurrence) {
        this.occurrences.add(occurrence);
    }

    /**
     * Converts a character to its corresponding index in the `children` array.
     * For example, 'a' -> 0, 'b' -> 1, ..., 'z' -> 25.
     *
     * @param c The character to convert.
     * @return An integer index corresponding to the position of the character in the alphabet.
     */
    public int charToIndex(char c) {
        return c - 'a'; // Subtracts the ASCII value of 'a' to get the index (0-25)
    }
}
