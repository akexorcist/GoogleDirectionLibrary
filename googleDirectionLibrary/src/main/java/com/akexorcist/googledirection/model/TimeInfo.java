package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class TimeInfo {
    String text;
    @SerializedName("time_zone")
    String timeZone;
    String value;

    public String getText() {
        return text;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getValue() {
        return value;
    }
}
