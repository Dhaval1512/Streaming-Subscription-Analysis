package com.example.controller;

// Import required classes and libraries
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StreamingServicePlan; // Represents the structure of a streaming service plan
import com.example.service.BestPlanService; // Service to handle logic for finding the best plans
import com.example.service.SearchHistoryService; // Service to manage search history (currently unused in this code)

/**
 * REST Controller for handling streaming service-related API endpoints.
 */
@RestController
public class StreamingServiceController {

    // Service for finding the best streaming service plans
    private final BestPlanService bestPlanService;

    // Service for handling search history (currently declared but unused)
    private SearchHistoryService searchHistoryService;

    /**
     * Constructor for injecting the BestPlanService dependency into the controller.
     *
     * @param bestPlanService the service used to find the best plans
     */
    @Autowired // Marks this constructor for dependency injection
    public StreamingServiceController(BestPlanService bestPlanService) {
        this.bestPlanService = bestPlanService;
    }

    /**
     * API endpoint to fetch the two best streaming service plans based on the lowest price.
     *
     * @return a list of two StreamingServicePlan objects representing the best plans
     */
    @GetMapping("/api/best-plans")
    public List<StreamingServicePlan> getBestPlans() {
        // Delegate the logic for fetching the best plans to the BestPlanService
        return bestPlanService.getBestPlans();
    }
}
