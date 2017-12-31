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

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.PolyUtil;

import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@SuppressWarnings("WeakerAccess")
public class RoutePolyline implements Parcelable {
    @SerializedName("points")
    private String rawPointList;

    public RoutePolyline() {
    }

    protected RoutePolyline(Parcel in) {
        rawPointList = in.readString();
    }

    public String getRawPointList() {
        return rawPointList;
    }

    public void setRawPointList(String rawPointList) {
        this.rawPointList = rawPointList;
    }

    public List<LatLng> getPointList() {
        return PolyUtil.decode(rawPointList);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rawPointList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RoutePolyline> CREATOR = new Creator<RoutePolyline>() {
        @Override
        public RoutePolyline createFromParcel(Parcel in) {
            return new RoutePolyline(in);
        }

        @Override
        public RoutePolyline[] newArray(int size) {
            return new RoutePolyline[size];
        }
    };
}
