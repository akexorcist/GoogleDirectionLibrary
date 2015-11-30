package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Vehicle {
    @SerializedName("icon")
    String iconUrl;
    String name;
    String type;

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
