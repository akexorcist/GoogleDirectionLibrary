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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@SuppressWarnings("WeakerAccess")
public class Step implements Parcelable {
    @SerializedName("distance")
    private Info distance;
    @SerializedName("duration")
    private Info duration;
    @SerializedName("end_location")
    private Coordination endLocation;
    @SerializedName("html_instructions")
    private String htmlInstruction;
    @SerializedName("maneuver")
    private String maneuver;
    @SerializedName("start_location")
    private Coordination startLocation;
    @SerializedName("transit_details")
    private TransitDetail transitDetail;
    @SerializedName("steps")
    private List<Step> stepList;
    @SerializedName("polyline")
    private RoutePolyline polyline;
    @SerializedName("travel_mode")
    private String travelMode;

    public Step() {
    }

    protected Step(Parcel in) {
        distance = in.readParcelable(Info.class.getClassLoader());
        duration = in.readParcelable(Info.class.getClassLoader());
        endLocation = in.readParcelable(Coordination.class.getClassLoader());
        htmlInstruction = in.readString();
        maneuver = in.readString();
        startLocation = in.readParcelable(Coordination.class.getClassLoader());
        stepList = in.createTypedArrayList(Step.CREATOR);
        travelMode = in.readString();
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

    public Coordination getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Coordination endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstruction() {
        return htmlInstruction;
    }

    public void setHtmlInstruction(String htmlInstruction) {
        this.htmlInstruction = htmlInstruction;
    }

    public String getManeuver() {
        return maneuver;
    }

    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    public Coordination getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Coordination startLocation) {
        this.startLocation = startLocation;
    }

    public TransitDetail getTransitDetail() {
        return transitDetail;
    }

    public void setTransitDetail(TransitDetail transitDetail) {
        this.transitDetail = transitDetail;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public boolean isContainStepList() {
        return stepList != null && stepList.size() > 0;
    }

    public RoutePolyline getPolyline() {
        return polyline;
    }

    public void setPolyline(RoutePolyline polyline) {
        this.polyline = polyline;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(distance, flags);
        dest.writeParcelable(duration, flags);
        dest.writeParcelable(endLocation, flags);
        dest.writeString(htmlInstruction);
        dest.writeString(maneuver);
        dest.writeParcelable(startLocation, flags);
        dest.writeTypedList(stepList);
        dest.writeString(travelMode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };
}
