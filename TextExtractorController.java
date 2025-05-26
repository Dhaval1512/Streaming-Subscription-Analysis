package com.example.controller;

// Import necessary classes and libraries
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.TextExtractorService;

/**
 * REST Controller for handling text extraction functionality.
 * It allows users to extract text from uploaded files based on a specific domain.
 */
@RestController
@RequestMapping("/TextExtractorController") // Base URL for endpoints in this controller
public class TextExtractorController {

    // Service to handle the business logic for text extraction
    private final TextExtractorService textExtractorService;

    /**
     * Constructor for injecting the TextExtractorService dependency into the controller.
     *
     * @param textExtractorService the service used for text extraction
     */
    @Autowired
    public TextExtractorController(TextExtractorService textExtractorService) {
        this.textExtractorService = textExtractorService;
    }

    /**
     * Endpoint to extract text from a file.
     *
     * @param domain the domain or category for which text needs to be extracted
     * @param file the file uploaded by the user
     * @return ResponseEntity containing the extracted text or an error message
     */
    @PostMapping("/extract") // HTTP POST endpoint for text extraction
    public ResponseEntity<String> extractText(
            @RequestParam("domain") String domain, // Extracted domain parameter from the request
            @RequestParam("file") MultipartFile file // File parameter containing the uploaded file
    ) {
        try {
            // Call the service to extract text based on the domain and file
            String extractedText = textExtractorService.extractText(domain, file);
            // Return the extracted text with an HTTP 200 (OK) status
            return ResponseEntity.ok(extractedText);
        } catch (Exception e) {
            // Handle exceptions by returning an HTTP 400 (Bad Request) status with an error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to extract text");
        }
    }
}
