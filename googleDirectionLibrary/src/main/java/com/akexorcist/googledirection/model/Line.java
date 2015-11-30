package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Line {
    @SerializedName("agencies")
    List<Agency> agencyList;
    String color;
    String name;
    @SerializedName("short_name")
    String shortName;
    @SerializedName("text_color")
    String textColor;
    Vehicle vehicle;

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getTextColor() {
        return textColor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
