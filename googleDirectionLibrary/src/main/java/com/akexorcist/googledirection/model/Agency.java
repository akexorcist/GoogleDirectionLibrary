package com.akexorcist.googledirection.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Agency {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
