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

import com.akexorcist.googledirection.constant.RequestResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@SuppressWarnings("WeakerAccess")
public class Direction implements Parcelable {
    @SerializedName("geocoded_waypoints")
    private List<GeocodedWaypoint> geocodedWaypointList;
    @SerializedName("routes")
    private List<Route> routeList;
    private String status;
    @SerializedName("error_message")
    private String errorMessage;

    public Direction() {
    }

    protected Direction(Parcel in) {
        status = in.readString();
        errorMessage = in.readString();
    }

    public void setGeocodedWaypointList(List<GeocodedWaypoint> geocodedWaypointList) {
        this.geocodedWaypointList = geocodedWaypointList;
    }

    public List<GeocodedWaypoint> getGeocodedWaypointList() {
        return geocodedWaypointList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isOK() {
        return RequestResult.OK.equals(status);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(errorMessage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Direction> CREATOR = new Creator<Direction>() {
        @Override
        public Direction createFromParcel(Parcel in) {
            return new Direction(in);
        }

        @Override
        public Direction[] newArray(int size) {
            return new Direction[size];
        }
    };
}
