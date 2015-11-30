package com.akexorcist.googledirection.request;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionRequestParam {
    LatLng origin;
    LatLng destination;
    String transportMode;
    String language;
    String unit;
    String avoid;
    String transitMode;
    boolean alternatives;
    String apiKey;

    public LatLng getOrigin() {
        return origin;
    }

    public DirectionRequestParam setOrigin(LatLng origin) {
        this.origin = origin;
        return this;
    }

    public LatLng getDestination() {
        return destination;
    }

    public DirectionRequestParam setDestination(LatLng destination) {
        this.destination = destination;
        return this;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAvoid() {
        return avoid;
    }

    public void setAvoid(String avoid) {
        this.avoid = avoid;
    }

    public String getTransitMode() {
        return transitMode;
    }

    public void setTransitMode(String transitMode) {
        this.transitMode = transitMode;
    }

    public boolean isAlternatives() {
        return alternatives;
    }

    public void setAlternatives(boolean alternatives) {
        this.alternatives = alternatives;
    }

    public String getApiKey() {
        return apiKey;
    }

    public DirectionRequestParam setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }
}
