package com.example.model;

/**
 * Represents a plan offered by a streaming service, including various attributes
 * such as service name, plan name, pricing details, features, and more.
 */
public class StreamingServicePlan {

    // Name of the streaming service (e.g., Netflix, Disney+)
    private String serviceName;

    // Name of the specific plan (e.g., Basic, Premium)
    private String planName;

    // Monthly price of the plan
    private String price;

    // Annual price of the plan
    private String annualPrice;

    // List of features included in the plan
    private String features;

    // Number of simultaneous streams allowed
    private int simultaneousStream;

    // Indicates if the plan supports content downloads (Yes/No)
    private String download;

    // Indicates if the plan offers ad-free streaming (Yes/No)
    private String adFreeStreaming;

    // Getters and setters

    /**
     * Gets the name of the streaming service.
     * 
     * @return The name of the streaming service.
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the name of the streaming service.
     * 
     * @param serviceName The name to set.
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Gets the name of the plan.
     * 
     * @return The name of the plan.
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the name of the plan.
     * 
     * @param planName The name to set.
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Gets the monthly price of the plan.
     * 
     * @return The monthly price.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the monthly price of the plan.
     * 
     * @param price The price to set.
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets the annual price of the plan.
     * 
     * @return The annual price.
     */
    public String getAnnualPrice() {
        return annualPrice;
    }

    /**
     * Sets the annual price of the plan.
     * 
     * @param annualPrice The annual price to set.
     */
    public void setAnnualPrice(String annualPrice) {
        this.annualPrice = annualPrice;
    }

    /**
     * Gets the features included in the plan.
     * 
     * @return The features.
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Sets the features included in the plan.
     * 
     * @param features The features to set.
     */
    public void setFeatures(String features) {
        this.features = features;
    }

    /**
     * Gets the number of simultaneous streams allowed by the plan.
     * 
     * @return The number of simultaneous streams.
     */
    public int getSimultaneousStream() {
        return simultaneousStream;
    }

    /**
     * Sets the number of simultaneous streams allowed by the plan.
     * 
     * @param simultaneousStream The number to set.
     */
    public void setSimultaneousStream(int simultaneousStream) {
        this.simultaneousStream = simultaneousStream;
    }

    /**
     * Gets the download capability of the plan.
     * 
     * @return "Yes" if downloads are supported, otherwise "No".
     */
    public String getDownload() {
        return download;
    }

    /**
     * Sets the download capability of the plan.
     * 
     * @param download "Yes" if downloads are supported, otherwise "No".
     */
    public void setDownload(String download) {
        this.download = download;
    }

    /**
     * Gets the ad-free streaming capability of the plan.
     * 
     * @return "Yes" if ad-free streaming is available, otherwise "No".
     */
    public String getAdFreeStreaming() {
        return adFreeStreaming;
    }

    /**
     * Sets the ad-free streaming capability of the plan.
     * 
     * @param adFreeStreaming "Yes" if ad-free streaming is available, otherwise "No".
     */
    public void setAdFreeStreaming(String adFreeStreaming) {
        this.adFreeStreaming = adFreeStreaming;
    }

    /**
     * Returns a string representation of the StreamingServicePlan object,
     * including all its attributes.
     * 
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "StreamingServicePlan{" +
                "serviceName='" + serviceName + '\'' +
                ", planName='" + planName + '\'' +
                ", price='" + price + '\'' +
                ", annualPrice='" + annualPrice + '\'' +
                ", features='" + features + '\'' +
                ", simultaneousStream=" + simultaneousStream +
                ", download='" + download + '\'' +
                ", adFreeStreaming='" + adFreeStreaming + '\'' +
                '}';
    }
}
