package com.example.model;

/**
 * Represents an occurrence of a keyword or phrase in a specific file.
 * Stores information about the page index, position in the text, and the filename.
 */
public class Occurrence {

    // Index of the page where the occurrence is found
    private int pageIndex;

    // Position within the page or text where the occurrence is located
    private int position;

    // Name of the file containing the occurrence
    private String filename;

    /**
     * Constructor to initialize an Occurrence object.
     *
     * @param pageIndex Index of the page where the keyword is found
     * @param position  Position of the keyword in the text
     * @param filename  Name of the file containing the occurrence
     */
    public Occurrence(int pageIndex, int position, String filename) {
        this.pageIndex = pageIndex;
        this.position = position;
        this.filename = filename;
    }

    /**
     * Getter method for pageIndex.
     *
     * @return The index of the page where the keyword is found
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * Setter method for pageIndex.
     *
     * @param pageIndex The new index of the page to set
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * Getter method for position.
     *
     * @return The position of the keyword in the text
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter method for position.
     *
     * @param position The new position of the keyword to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Getter method for filename.
     *
     * @return The name of the file containing the occurrence
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Setter method for filename.
     *
     * @param filename The new name of the file to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Provides a string representation of the Occurrence object.
     * Useful for debugging and logging purposes.
     *
     * @return A string containing details about the occurrence
     */
    @Override
    public String toString() {
        return "Occurrence{" +
                "pageIndex=" + pageIndex +
                ", position=" + position +
                ", filename='" + filename + '\'' +
                '}';
    }
}
