package com.akexorcist.googledirection.config;

import okhttp3.OkHttpClient;

/**
 * Configuration class for the Google Direction Library.
 *
 * @since 1.0.0
 */

public class GoogleDirectionConfiguration {
    private static GoogleDirectionConfiguration configuration;

    /**
     * Call the class with singleton pattern
     *
     * @return The singleton object of this class
     * @since 1.0.0
     */
    public static GoogleDirectionConfiguration getInstance() {
        if (configuration == null) {
            configuration = new GoogleDirectionConfiguration();
        }
        return configuration;
    }

    private OkHttpClient customClient;
    private boolean isLogEnabled = false;

    /**
     * Get the custom OkHttpClient
     *
     * @return The OkHttpClient object
     * @since 1.0.0
     */
    public OkHttpClient getCustomClient() {
        return customClient;
    }

    /**
     * Set the custom OkHttpClient to replace the default client in this library
     *
     * @param customClient The OkHttpClient object
     * @since 1.0.0
     */
    public void setCustomClient(OkHttpClient customClient) {
        this.customClient = customClient;
    }

    /**
     * Is the API request logging enable or disable
     *
     * @return The value will be true for enable and false for disable
     * @since 1.0.0
     */
    public boolean isLogEnabled() {
        return isLogEnabled;
    }

    /**
     * Enable or disable the API request logging (Powered by OkHttp Logging Interceptor)
     *
     * @param logEnabled true for enable and false for disable
     * @since 1.0.0
     */
    public void setLogEnabled(boolean logEnabled) {
        isLogEnabled = logEnabled;
    }
}
