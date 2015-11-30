package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class GeocodedWaypoint {
    @SerializedName("geocoder_status")
    String status;
    @SerializedName("place_id")
    String placeId;
    List<String> types;

    public String getStatus() {
        return status;
    }

    public String getPlaceId() {
        return placeId;
    }

    public List<String> getTypes() {
        return types;
    }
}
