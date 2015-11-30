package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Step {
    Info distance;
    Info duration;
    @SerializedName("end_location")
    Coordination endLocation;
    @SerializedName("html_instructions")
    String htmlInstruction;
    String maneuver;
    @SerializedName("start_location")
    Coordination startLocation;
    @SerializedName("transit_details")
    TransitDetail transitDetail;
    @SerializedName("steps")
    List<Step> stepList;
    RoutePolyline polyline;
    @SerializedName("travel_mode")
    String travelMode;

    public Info getDistance() {
        return distance;
    }

    public Info getDuration() {
        return duration;
    }

    public Coordination getEndLocation() {
        return endLocation;
    }

    public String getHtmlInstruction() {
        return htmlInstruction;
    }

    public String getManeuver() {
        return maneuver;
    }

    public Coordination getStartLocation() {
        return startLocation;
    }

    public TransitDetail getTransitDetail() {
        return transitDetail;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public boolean isContainStepList() {
        return stepList != null && stepList.size() > 0;
    }

    public RoutePolyline getPolyline() {
        return polyline;
    }

    public String getTravelMode() {
        return travelMode;
    }
}
