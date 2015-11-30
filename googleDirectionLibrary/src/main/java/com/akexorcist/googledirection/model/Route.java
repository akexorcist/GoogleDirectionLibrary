package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Route {
    @SerializedName("bounds")
    Bound bound;
    String copyrights;
    @SerializedName("legs")
    List<Leg> legList;
    @SerializedName("overview_polyline")
    RoutePolyline overviewPolyline;
    String summary;
    Fare fare;
    @SerializedName("warnings")
    List<String> warningList;
    // waypoint_order

    public Bound getBound() {
        return bound;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public List<Leg> getLegList() {
        return legList;
    }

    public RoutePolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public String getSummary() {
        return summary;
    }

    public Fare getFare() {
        return fare;
    }

    public List<String> getWarningList() {
        return warningList;
    }
}
