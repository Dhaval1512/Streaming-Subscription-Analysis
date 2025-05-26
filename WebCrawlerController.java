package com.example.controller;

// Import necessary classes and libraries
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup; // Library for fetching and parsing HTML
import org.jsoup.nodes.Document; // Represents the entire HTML document
import org.jsoup.nodes.Element; // Represents a single HTML element
import org.jsoup.select.Elements; // Represents a collection of HTML elements
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for web crawling functionality.
 * Allows users to extract all links (URLs) from a given webpage.
 */
@RestController
public class WebCrawlerController {

    /**
     * API endpoint to crawl a website and extract all links.
     *
     * @param url The URL of the website to crawl.
     * @return A list of all extracted links (absolute URLs) from the given webpage.
     */
    @GetMapping("/api/crawl")
    public List<String> crawlWebsite(@RequestParam String url) {
        // List to store the extracted links
        List<String> links = new ArrayList<>();
        try {
            // Validate the input URL
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("URL cannot be empty");
            }

            // Fetch the HTML content of the provided URL using Jsoup
            Document doc = Jsoup.connect(url).get(); // Connect to the URL and retrieve the document

            // Select all anchor tags (<a>) with an href attribute
            Elements linkElements = doc.select("a[href]");

            // Iterate over the extracted elements and store their absolute URLs
            for (Element link : linkElements) {
                String absUrl = link.absUrl("href"); // Get the absolute URL of the link
                if (absUrl != null && !absUrl.isEmpty()) {
                    links.add(absUrl); // Add the URL to the list if it's valid
                }
            }
        } catch (IOException e) {
            // Handle network-related errors, such as connectivity issues
            e.printStackTrace();
            throw new RuntimeException("Error fetching URL: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle invalid input errors, such as an empty or null URL
            e.printStackTrace();
            throw new RuntimeException("Invalid input: " + e.getMessage());
        }

        // Return the list of extracted links as a JSON response
        return links;
    }
}
