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

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@SuppressWarnings("WeakerAccess")
public class TransitDetail implements Parcelable {
    @SerializedName("arrival_stop")
    private StopPoint arrivalStopPoint;
    @SerializedName("arrival_time")
    private TimeInfo arrivalTime;
    @SerializedName("departure_stop")
    private StopPoint departureStopPoint;
    @SerializedName("departure_time")
    private TimeInfo departureTime;
    private Line line;
    private String headsign;
    @SerializedName("num_stops")
    private String stopNumber;

    public TransitDetail() {
    }

    protected TransitDetail(Parcel in) {
        arrivalStopPoint = in.readParcelable(StopPoint.class.getClassLoader());
        arrivalTime = in.readParcelable(TimeInfo.class.getClassLoader());
        departureStopPoint = in.readParcelable(StopPoint.class.getClassLoader());
        departureTime = in.readParcelable(TimeInfo.class.getClassLoader());
        line = in.readParcelable(Line.class.getClassLoader());
        headsign = in.readString();
        stopNumber = in.readString();
    }

    public StopPoint getArrivalStopPoint() {
        return arrivalStopPoint;
    }

    public void setArrivalStopPoint(StopPoint arrivalStopPoint) {
        this.arrivalStopPoint = arrivalStopPoint;
    }

    public TimeInfo getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(TimeInfo arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public StopPoint getDepartureStopPoint() {
        return departureStopPoint;
    }

    public void setDepartureStopPoint(StopPoint departureStopPoint) {
        this.departureStopPoint = departureStopPoint;
    }

    public TimeInfo getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(TimeInfo departureTime) {
        this.departureTime = departureTime;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public String getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(String stopNumber) {
        this.stopNumber = stopNumber;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(arrivalStopPoint, flags);
        dest.writeParcelable(arrivalTime, flags);
        dest.writeParcelable(departureStopPoint, flags);
        dest.writeParcelable(departureTime, flags);
        dest.writeParcelable(line, flags);
        dest.writeString(headsign);
        dest.writeString(stopNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TransitDetail> CREATOR = new Creator<TransitDetail>() {
        @Override
        public TransitDetail createFromParcel(Parcel in) {
            return new TransitDetail(in);
        }

        @Override
        public TransitDetail[] newArray(int size) {
            return new TransitDetail[size];
        }
    };
}
