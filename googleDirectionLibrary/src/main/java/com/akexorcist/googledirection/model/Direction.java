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
    @SerializedName("error_message")
    String errorMessage;

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

    public String getErrorMessage() {
        return errorMessage;
    }
}
