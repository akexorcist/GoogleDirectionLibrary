package com.akexorcist.googledirection.request;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionOriginRequest {
    private String apiKey;

    public DirectionOriginRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public DirectionDestinationRequest from(LatLng origin) {
        return new DirectionDestinationRequest(apiKey, origin);
    }
}
