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

package com.akexorcist.googledirection.request;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * For internal use.
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class DirectionRequestParam implements Parcelable {
    private LatLng origin;
    private LatLng destination;
    private String transportMode;
    private String departureTime;
    private String language;
    private String unit;
    private String avoid;
    private String transitMode;
    private String trafficModel;
    private String transitRoutingPreference;
    private boolean alternatives;
    private String apiKey;
    private List<LatLng> waypoints;
    private boolean optimizeWaypoints;

    public DirectionRequestParam() {
    }

    protected DirectionRequestParam(Parcel in) {
        origin = in.readParcelable(LatLng.class.getClassLoader());
        destination = in.readParcelable(LatLng.class.getClassLoader());
        transportMode = in.readString();
        departureTime = in.readString();
        language = in.readString();
        unit = in.readString();
        avoid = in.readString();
        transitMode = in.readString();
        trafficModel = in.readString();
        transitRoutingPreference = in.readString();
        alternatives = in.readByte() != 0;
        apiKey = in.readString();
        waypoints = in.createTypedArrayList(LatLng.CREATOR);
        optimizeWaypoints = in.readByte() != 0;
    }

    @Nullable
    public LatLng getOrigin() {
        return origin;
    }

    public DirectionRequestParam setOrigin(@Nullable LatLng origin) {
        this.origin = origin;
        return this;
    }

    @Nullable
    public LatLng getDestination() {
        return destination;
    }

    public DirectionRequestParam setDestination(@Nullable LatLng destination) {
        this.destination = destination;
        return this;
    }

    @Nullable
    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(@Nullable String transportMode) {
        this.transportMode = transportMode;
    }

    @Nullable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(@Nullable String language) {
        this.language = language;
    }

    @Nullable
    public String getUnit() {
        return unit;
    }

    public void setUnit(@Nullable String unit) {
        this.unit = unit;
    }

    @Nullable
    public String getAvoid() {
        return avoid;
    }

    public void setAvoid(@Nullable String avoid) {
        this.avoid = avoid;
    }

    @Nullable
    public String getTransitMode() {
        return transitMode;
    }

    public void setTransitMode(@Nullable String transitMode) {
        this.transitMode = transitMode;
    }

    @Nullable
    public String getTrafficModel() {
        return trafficModel;
    }

    public void setTrafficModel(@Nullable String trafficModel) {
        this.trafficModel = trafficModel;
    }

    @Nullable
    public String getTransitRoutingPreference() {
        return transitRoutingPreference;
    }

    public void setTransitRoutingPreference(@Nullable String transitRoutingPreference) {
        this.transitRoutingPreference = transitRoutingPreference;
    }

    public boolean isAlternatives() {
        return alternatives;
    }

    public void setAlternatives(boolean alternatives) {
        this.alternatives = alternatives;
    }

    @Nullable
    public String getApiKey() {
        return apiKey;
    }

    public DirectionRequestParam setApiKey(@Nullable String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    @Nullable
    public String getDepartureTime() {
        return departureTime;
    }

    public DirectionRequestParam setDepartureTime(@Nullable String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    @Nullable
    public List<LatLng> getWaypoints() {
        return waypoints;
    }

    public DirectionRequestParam setWaypoints(@Nullable List<LatLng> waypoints) {
        this.waypoints = waypoints;
        return this;
    }

    public boolean isOptimizeWaypoints() {
        return optimizeWaypoints;
    }

    public DirectionRequestParam setOptimizeWaypoints(boolean optimizeWaypoints) {
        this.optimizeWaypoints = optimizeWaypoints;
        return this;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(origin, flags);
        dest.writeParcelable(destination, flags);
        dest.writeString(transportMode);
        dest.writeString(departureTime);
        dest.writeString(language);
        dest.writeString(unit);
        dest.writeString(avoid);
        dest.writeString(transitMode);
        dest.writeString(trafficModel);
        dest.writeString(transitRoutingPreference);
        dest.writeByte((byte) (alternatives ? 1 : 0));
        dest.writeString(apiKey);
        dest.writeTypedList(waypoints);
        dest.writeByte((byte) (optimizeWaypoints ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DirectionRequestParam> CREATOR = new Creator<DirectionRequestParam>() {
        @Override
        public DirectionRequestParam createFromParcel(Parcel in) {
            return new DirectionRequestParam(in);
        }

        @Override
        public DirectionRequestParam[] newArray(int size) {
            return new DirectionRequestParam[size];
        }
    };
}
