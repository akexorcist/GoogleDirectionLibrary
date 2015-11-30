package com.akexorcist.googledirection;

import com.akexorcist.googledirection.request.DirectionOriginRequest;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class GoogleDirection {
    public static DirectionOriginRequest withServerKey(String apiKey) {
        return new DirectionOriginRequest(apiKey);
    }
}
