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
