package com.example.controller;

// Import necessary classes and libraries
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration class for handling Cross-Origin Resource Sharing (CORS) settings.
 * This ensures that frontend applications hosted on different origins can communicate with this backend API.
 */
@Configuration
public class MyCorsFilter {

    /**
     * Configures a CORS filter for the application.
     * 
     * @return a new instance of CorsFilter with the specified configuration
     */
    @Bean
    public CorsFilter corsFilter() {
        // Create a new CORS configuration
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Allow requests from the frontend URL
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:5500"); // Replace with the actual frontend origin

        // Allow specific HTTP methods for CORS
        corsConfiguration.addAllowedMethod("GET");    // Allow GET requests
        corsConfiguration.addAllowedMethod("POST");   // Allow POST requests
        corsConfiguration.addAllowedMethod("PUT");    // Allow PUT requests
        corsConfiguration.addAllowedMethod("DELETE"); // Allow DELETE requests

        // Allow all headers in requests
        corsConfiguration.addAllowedHeader("*"); // Accept any header sent by the client

        // Create a source to map the CORS configuration to all endpoints (/**)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Apply CORS settings to all endpoints

        // Return a new CorsFilter with the defined source configuration
        return new CorsFilter(source);
    }
}
