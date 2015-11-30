package com.akexorcist.googledirection.model;

import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class RoutePolyline {
    @SerializedName("points")
    String rawPointList;

    public String getRawPointList() {
        return rawPointList;
    }

    public ArrayList<LatLng> getPointList() {
        return DirectionConverter.decodePoly(rawPointList);
    }
}
