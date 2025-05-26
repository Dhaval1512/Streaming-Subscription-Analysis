package com.example.controller;

// Import necessary classes and libraries
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PageContent; // Represents the structure of a page's content
import com.example.service.CsvService; // Service layer handling CSV data operations

/**
 * REST Controller for handling page ranking-related API endpoints.
 */
@RestController
public class PageRankController {

    // Service layer dependency for processing CSV data
    private final CsvService csvService;

    /**
     * Constructor for injecting the CsvService dependency into the controller.
     *
     * @param csvService the service used to handle CSV-related operations
     */
    public PageRankController(CsvService csvService) {
        this.csvService = csvService;
    }

    /**
     * API endpoint to rank pages based on a given search query.
     *
     * @param query the search keyword or phrase used to rank pages
     * @return a list of ranked PageContent objects based on the query
     */
    @GetMapping("/api/rank")
    public List<PageContent> rankPages(@RequestParam String query) {
        // Delegate the task of ranking pages to the CsvService
        return csvService.rankPages(query);
    }
}
