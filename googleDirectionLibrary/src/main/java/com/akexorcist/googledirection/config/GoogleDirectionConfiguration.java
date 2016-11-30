package com.akexorcist.googledirection.config;

import okhttp3.OkHttpClient;

/**
 * Created by Akexorcist on 12/1/2016 AD.
 */

public class GoogleDirectionConfiguration {
    private static GoogleDirectionConfiguration configuration;

    public static GoogleDirectionConfiguration getInstance() {
        if (configuration == null) {
            configuration = new GoogleDirectionConfiguration();
        }
        return configuration;
    }

    private OkHttpClient customClient;
    private boolean isLogEnabled = false;

    public OkHttpClient getCustomClient() {
        return customClient;
    }

    public void setCustomClient(OkHttpClient customClient) {
        this.customClient = customClient;
    }

    public boolean isLogEnabled() {
        return isLogEnabled;
    }

    public void setLogEnabled(boolean logEnabled) {
        isLogEnabled = logEnabled;
    }
}
