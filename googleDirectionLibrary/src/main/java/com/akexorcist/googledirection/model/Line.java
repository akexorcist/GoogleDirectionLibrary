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
public class Line {
    @SerializedName("agencies")
    List<Agency> agencyList;
    String color;
    String name;
    @SerializedName("short_name")
    String shortName;
    @SerializedName("text_color")
    String textColor;
    Vehicle vehicle;

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getTextColor() {
        return textColor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
