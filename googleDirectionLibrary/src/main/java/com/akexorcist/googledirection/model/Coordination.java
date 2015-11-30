package com.akexorcist.googledirection.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Coordination {
    @SerializedName("lat")
    double latitude;
    @SerializedName("lng")
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LatLng getCoordination() {
        return new LatLng(latitude, longitude);
    }
}
