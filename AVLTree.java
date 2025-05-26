package com.example.model;

/**
 * Implementation of an AVL Tree, a self-balancing binary search tree.
 * Each node in the tree stores a word, its frequency, and height.
 * The tree automatically maintains balance during insertions.
 */
public class AVLTree {

    // Nested class representing a node in the AVL Tree
    private class TreeNode {
        String key;        // The word stored in the node
        int count;         // Frequency of the word
        int height;        // Height of the node in the tree
        TreeNode left, right; // Pointers to the left and right child nodes

        /**
         * Constructor to create a new TreeNode with the given key.
         * Initializes frequency to 1 and height to 1 (leaf node).
         *
         * @param key The word to store in this node
         */
        TreeNode(String key) {
            this.key = key;
            this.count = 1;  // Default frequency is 1 when the key is first inserted
            this.height = 1; // Default height is 1 for a new leaf node
        }
    }

    private TreeNode rootNode; // The root node of the AVL Tree

    /**
     * Public method to insert a word into the AVL Tree.
     *
     * @param word The word to be inserted into the tree
     */
    public void insert(String word) {
        rootNode = insertIntoTree(rootNode, word); // Start insertion from the root node
    }

    /**
     * Private recursive method to insert a word into the AVL Tree.
     * Automatically balances the tree after the word is inserted.
     *
     * @param currentNode The current node being examined during insertion
     * @param newKey      The word to insert into the tree
     * @return The updated TreeNode after insertion
     */
    private TreeNode insertIntoTree(TreeNode currentNode, String newKey) {
        if (currentNode == null) { // Base case: If the current node is null, create a new node
            return new TreeNode(newKey);
        }

        // Compare the word being inserted with the current node's key
        int comparison = newKey.compareTo(currentNode.key);

        // If the new word is smaller, recurse into the left subtree
        if (comparison < 0) {
            currentNode.left = insertIntoTree(currentNode.left, newKey);
        }
        // If the new word is larger, recurse into the right subtree
        else if (comparison > 0) {
            currentNode.right = insertIntoTree(currentNode.right, newKey);
        }
        // If the word already exists in the tree, increment its frequency
        else {
            currentNode.count++;
        }

        // Update the height of the current node after insertion
        currentNode.height = 1 + Math.max(getHeight(currentNode.left), getHeight(currentNode.right));

        // Balance the tree and return the updated node
        return balanceTree(currentNode);
    }

    /**
     * Balances the AVL Tree if the given node becomes unbalanced.
     *
     * @param unbalancedNode The node to balance
     * @return The balanced node
     */
    private TreeNode balanceTree(TreeNode unbalancedNode) {
        int balanceFactor = calculateBalanceFactor(unbalancedNode); // Compute the balance factor

        // Left-heavy case
        if (balanceFactor > 1) {
            // Left-Right case: Perform a left rotation on the left child
            if (calculateBalanceFactor(unbalancedNode.left) < 0) {
                unbalancedNode.left = performLeftRotation(unbalancedNode.left);
            }
            // Perform a right rotation
            unbalancedNode = performRightRotation(unbalancedNode);
        }
        // Right-heavy case
        else if (balanceFactor < -1) {
            // Right-Left case: Perform a right rotation on the right child
            if (calculateBalanceFactor(unbalancedNode.right) > 0) {
                unbalancedNode.right = performRightRotation(unbalancedNode.right);
            }
            // Perform a left rotation
            unbalancedNode = performLeftRotation(unbalancedNode);
        }

        return unbalancedNode; // Return the balanced node
    }

    /**
     * Calculates the height of a given TreeNode.
     *
     * @param treeNode The node whose height is to be calculated
     * @return The height of the node, or 0 if the node is null
     */
    private int getHeight(TreeNode treeNode) {
        return treeNode == null ? 0 : treeNode.height;
    }

    /**
     * Calculates the balance factor of a given TreeNode.
     * Balance factor = height of left subtree - height of right subtree.
     *
     * @param treeNode The node whose balance factor is to be calculated
     * @return The balance factor of the node
     */
    private int calculateBalanceFactor(TreeNode treeNode) {
        return treeNode == null ? 0 : getHeight(treeNode.left) - getHeight(treeNode.right);
    }

    /**
     * Performs a left rotation to balance the tree.
     *
     * @param unbalancedNode The unbalanced node
     * @return The new root after the rotation
     */
    private TreeNode performLeftRotation(TreeNode unbalancedNode) {
        TreeNode newRoot = unbalancedNode.right; // The right child becomes the new root
        unbalancedNode.right = newRoot.left;    // The left subtree of the new root becomes the right child
        newRoot.left = unbalancedNode;          // The unbalanced node becomes the left child

        // Update heights of the affected nodes
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot; // Return the new root
    }

    /**
     * Performs a right rotation to balance the tree.
     *
     * @param unbalancedNode The unbalanced node
     * @return The new root after the rotation
     */
    private TreeNode performRightRotation(TreeNode unbalancedNode) {
        TreeNode newRoot = unbalancedNode.left; // The left child becomes the new root
        unbalancedNode.left = newRoot.right;    // The right subtree of the new root becomes the left child
        newRoot.right = unbalancedNode;         // The unbalanced node becomes the right child

        // Update heights of the affected nodes
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot; // Return the new root
    }

    /**
     * Retrieves the frequency of a word in the AVL Tree.
     *
     * @param searchKey The word to search for
     * @return The frequency of the word, or 0 if the word is not found
     */
    public int getFrequency(String searchKey) {
        TreeNode foundNode = findNode(rootNode, searchKey); // Search for the word in the tree
        return foundNode != null ? foundNode.count : 0;     // Return the frequency if found, else 0
    }

    /**
     * Searches for a word in the AVL Tree and returns the corresponding node.
     *
     * @param currentNode The current node being examined during the search
     * @param searchKey   The word to search for
     * @return The node containing the word, or null if not found
     */
    private TreeNode findNode(TreeNode currentNode, String searchKey) {
        if (currentNode == null) { // Base case: If the node is null, the word is not found
            return null;
        }

        int comparison = searchKey.compareTo(currentNode.key); // Compare the word with the current node's key

        // Recurse into the left or right subtree based on comparison
        if (comparison < 0) {
            return findNode(currentNode.left, searchKey);
        } else if (comparison > 0) {
            return findNode(currentNode.right, searchKey);
        } else { // If the word matches, return the current node
            return currentNode;
        }
    }
}
