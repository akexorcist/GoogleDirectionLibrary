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
public class GeocodedWaypoint implements Parcelable {
    @SerializedName("geocoder_status")
    private String status;
    @SerializedName("place_id")
    private String placeId;
    @SerializedName("types")
    private List<String> typeList;

    public GeocodedWaypoint() {
    }

    protected GeocodedWaypoint(Parcel in) {
        status = in.readString();
        placeId = in.readString();
        typeList = in.createStringArrayList();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(placeId);
        dest.writeStringList(typeList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GeocodedWaypoint> CREATOR = new Creator<GeocodedWaypoint>() {
        @Override
        public GeocodedWaypoint createFromParcel(Parcel in) {
            return new GeocodedWaypoint(in);
        }

        @Override
        public GeocodedWaypoint[] newArray(int size) {
            return new GeocodedWaypoint[size];
        }
    };
}
