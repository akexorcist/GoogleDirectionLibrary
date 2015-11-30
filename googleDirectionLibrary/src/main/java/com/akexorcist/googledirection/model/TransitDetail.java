package com.akexorcist.googledirection.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class TransitDetail {
    @SerializedName("arrival_stop")
    StopPoint arrivalStopPoint;
    @SerializedName("arrival_time")
    TimeInfo arrivalTime;
    @SerializedName("departure_stop")
    StopPoint departureStopPoint;
    @SerializedName("departure_time")
    TimeInfo departureTime;
    Line line;
    String headsign;
    @SerializedName("num_stops")
    String stopNumber;

    public StopPoint getArrivalStopPoint() {
        return arrivalStopPoint;
    }

    public TimeInfo getArrivalTime() {
        return arrivalTime;
    }

    public StopPoint getDepartureStopPoint() {
        return departureStopPoint;
    }

    public TimeInfo getDepartureTime() {
        return departureTime;
    }

    public Line getLine() {
        return line;
    }

    public String getHeadsign() {
        return headsign;
    }

    public String getStopNumber() {
        return stopNumber;
    }
}
