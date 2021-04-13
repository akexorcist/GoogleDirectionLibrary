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
public class Line implements Parcelable {
    @SerializedName("agencies")
    private List<Agency> agencyList;
    @SerializedName("color")
    private String color;
    @SerializedName("name")
    private String name;
    @SerializedName("short_name")
    private String shortName;
    @SerializedName("text_color")
    private String textColor;
    @SerializedName("vehicle")
    private Vehicle vehicle;

    public Line() {
    }

    protected Line(Parcel in) {
        agencyList = in.createTypedArrayList(Agency.CREATOR);
        color = in.readString();
        name = in.readString();
        shortName = in.readString();
        textColor = in.readString();
    }

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(List<Agency> agencyList) {
        this.agencyList = agencyList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(agencyList);
        dest.writeString(color);
        dest.writeString(name);
        dest.writeString(shortName);
        dest.writeString(textColor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Line> CREATOR = new Creator<Line>() {
        @Override
        public Line createFromParcel(Parcel in) {
            return new Line(in);
        }

        @Override
        public Line[] newArray(int size) {
            return new Line[size];
        }
    };
}
