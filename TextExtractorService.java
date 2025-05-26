package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service class for extracting and processing text from an uploaded file.
 * Extracts structured information such as emails, phone numbers, URLs, and dates.
 */
@Service
public class TextExtractorService {

    /**
     * Extracts text from the uploaded file and processes it to categorize data
     * such as emails, phone numbers, URLs, and dates.
     *
     * @param domain The domain for which the text is being extracted.
     * @param file   The uploaded file containing text.
     * @return Structured output of extracted data.
     */
    public String extractText(String domain, MultipartFile file) {
        // Check if the uploaded file is empty
        if (file.isEmpty()) {
            throw new IllegalArgumentException("The uploaded file is empty.");
        }

        // Initialize a StringBuilder to store raw text from the file
        StringBuilder rawText = new StringBuilder();

        // Lists to store categorized extracted data
        List<String> emails = new ArrayList<>();
        List<String> validPhones = new ArrayList<>();
        List<String> invalidPhones = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        // Regular expressions for matching specific patterns
        Pattern emailPattern = Pattern.compile("[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}"); // Matches email addresses
        Pattern phonePattern = Pattern.compile("\\d{10}"); // Matches 10-digit phone numbers
        Pattern urlPattern = Pattern.compile("https?://[\\w.-]+(/[\\w./?=%-]*)?"); // Matches URLs starting with http/https
        Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}"); // Matches dates in YYYY-MM-DD format

        // Read the file line by line using a BufferedReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;

            // Process each line in the file
            while ((line = reader.readLine()) != null) {
                rawText.append(line).append("\n"); // Append the line to rawText

                // Extract and categorize emails
                Matcher emailMatcher = emailPattern.matcher(line);
                while (emailMatcher.find()) {
                    emails.add(emailMatcher.group()); // Add matched emails to the list
                }

                // Extract and categorize phone numbers
                Matcher phoneMatcher = phonePattern.matcher(line);
                while (phoneMatcher.find()) {
                    String phone = phoneMatcher.group(); // Get the matched phone number
                    if (phone.startsWith("123") || phone.length() != 10) {
                        invalidPhones.add(phone); // Add to invalidPhones if it starts with "123" or is not 10 digits
                    } else {
                        validPhones.add(phone); // Otherwise, add to validPhones
                    }
                }

                // Extract and categorize URLs
                Matcher urlMatcher = urlPattern.matcher(line);
                while (urlMatcher.find()) {
                    urls.add(urlMatcher.group()); // Add matched URLs to the list
                }

                // Extract and categorize dates
                Matcher dateMatcher = datePattern.matcher(line);
                while (dateMatcher.find()) {
                    dates.add(dateMatcher.group()); // Add matched dates to the list
                }
            }
        } catch (IOException e) {
            // Handle any exceptions that occur while reading the file
            throw new RuntimeException("Failed to read the uploaded file.", e);
        }

        // Structure the extracted data into a readable format
        StringBuilder structuredOutput = new StringBuilder();
        structuredOutput.append("Extracted Text for Domain: ").append(domain).append("\n\n");

        // Add extracted emails to the output
        structuredOutput.append("Emails Validated:\n");
        for (String email : emails) {
            structuredOutput.append(email).append("\n");
        }

        // Add extracted valid phone numbers to the output
        structuredOutput.append("\nValid Phone Numbers:\n");
        for (String phone : validPhones) {
            structuredOutput.append(phone).append("\n");
        }

        // Add extracted invalid phone numbers to the output
        structuredOutput.append("\nInvalid Phone Numbers:\n");
        for (String phone : invalidPhones) {
            structuredOutput.append(phone).append("\n");
        }

        // Add extracted URLs to the output
        structuredOutput.append("\nURLs Found:\n");
        for (String url : urls) {
            structuredOutput.append(url).append("\n");
        }

        // Add extracted dates to the output
        structuredOutput.append("\nDates Found:\n");
        for (String date : dates) {
            structuredOutput.append(date).append("\n");
        }

        // Return the structured output as a string
        return structuredOutput.toString();
    }
}
