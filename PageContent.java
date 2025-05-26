package com.example.model;

/**
 * Represents the content of a page, including its title, main content, 
 * and the frequency of a specific keyword or search term.
 */
public class PageContent {

    // Title of the page
    private String title;

    // Main content or body text of the page
    private String content;

    // Frequency of a specific keyword in the page content
    private int frequency;

    /**
     * Constructor to initialize a PageContent object with a title and content.
     * The frequency is initialized to 0 by default.
     *
     * @param title   The title of the page
     * @param content The main content or body text of the page
     */
    public PageContent(String title, String content) {
        this.title = title;
        this.content = content;
        this.frequency = 0; // Default frequency is 0
    }

    /**
     * Getter method for the title of the page.
     *
     * @return The title of the page
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for the title of the page.
     *
     * @param title The new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for the main content of the page.
     *
     * @return The main content or body text of the page
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter method for the main content of the page.
     *
     * @param content The new content or body text to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter method for the frequency of a specific keyword in the page content.
     *
     * @return The frequency of the keyword
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Setter method for the frequency of a specific keyword in the page content.
     *
     * @param frequency The new frequency value to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
