/*

Copyright 2015 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package com.akexorcist.googledirection.model;

import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

public class Leg {
    @SerializedName("arrival_time")
    private TimeInfo arrivalTime;
    @SerializedName("departure_time")
    private TimeInfo departureTime;
    private Info distance;
    private Info duration;
    @SerializedName("duration_in_traffic")
    private Info durationInTraffic;
    @SerializedName("end_address")
    private String endAddress;
    @SerializedName("end_location")
    private Coordination endLocation;
    @SerializedName("start_address")
    private String startAddress;
    @SerializedName("start_location")
    private Coordination startLocation;
    @SerializedName("steps")
    private List<Step> stepList;
    @SerializedName("via_waypoint")
    private List<Waypoint> viaWaypointList;

    public TimeInfo getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(TimeInfo arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TimeInfo getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(TimeInfo departureTime) {
        this.departureTime = departureTime;
    }

    public Info getDistance() {
        return distance;
    }

    public void setDistance(Info distance) {
        this.distance = distance;
    }

    public Info getDuration() {
        return duration;
    }

    public void setDuration(Info duration) {
        this.duration = duration;
    }

    public Info getDurationInTraffic() {
        return durationInTraffic;
    }

    public void setDurationInTraffic(Info durationInTraffic) {
        this.durationInTraffic = durationInTraffic;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Coordination getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Coordination endLocation) {
        this.endLocation = endLocation;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public Coordination getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Coordination startLocation) {
        this.startLocation = startLocation;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public List<Waypoint> getViaWaypointList() {
        return viaWaypointList;
    }

    public void setViaWaypointList(List<Waypoint> viaWaypointList) {
        this.viaWaypointList = viaWaypointList;
    }

    public ArrayList<LatLng> getDirectionPoint() {
        return DirectionConverter.getDirectionPoint(stepList);
    }

    public ArrayList<LatLng> getSectionPoint() {
        return DirectionConverter.getSectionPoint(stepList);
    }
}
