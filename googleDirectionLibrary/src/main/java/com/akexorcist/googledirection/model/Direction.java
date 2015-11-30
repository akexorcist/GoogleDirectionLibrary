package com.akexorcist.googledirection.model;

import com.akexorcist.googledirection.constant.RequestResult;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Direction {
    @SerializedName("geocoded_waypoints")
    List<GeocodedWaypoint> geocodedWaypointList;
    @SerializedName("routes")
    List<Route> routeList;
    String status;

    public List<GeocodedWaypoint> getGeocodedWaypointList() {
        return geocodedWaypointList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public String getStatus() {
        return status;
    }

    public boolean isOK() {
        return status.equals(RequestResult.OK);
    }
}
