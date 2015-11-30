package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Waypoint {
    Coordination location;
    @SerializedName("step_index")
    int index;
    @SerializedName("step_interpolation")
    double interpolation;

    public Coordination getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }

    public double getInterpolation() {
        return interpolation;
    }
}
