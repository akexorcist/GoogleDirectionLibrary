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

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
@SuppressWarnings("WeakerAccess")
public class GeocodeRequestParam implements Parcelable {
    private LatLng location;
    private String language;
    private List<String> resulType;
    private List<String> locationType;
    private String apiKey;

    public GeocodeRequestParam() {
    }

    public LatLng getLocation() {
        return location;
    }

    public GeocodeRequestParam setLocation(LatLng location) {
        this.location = location;
        return this;
    }

    public  String getLanguage() {
        return language;
    }

    public GeocodeRequestParam  setLanguage(String language) {
        this.language = language;
        return this;
    }

    public  String getApiKey() {
        return apiKey;
    }

    public GeocodeRequestParam  setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public List<String> getResulType() {
        return resulType;
    }

    public GeocodeRequestParam setResulType(List<String> resulType) {
        this.resulType = resulType;
        return this;
    }

    public List<String> getLocationType() {
        return locationType;
    }

    public GeocodeRequestParam setLocationType(List<String> locationType) {
        this.locationType = locationType;
        return this;
    }



    protected GeocodeRequestParam(Parcel in) {
        location = (LatLng) in.readValue(LatLng.class.getClassLoader());
        language = in.readString();
        if (in.readByte() == 0x01) {
            resulType = new ArrayList<>();
            in.readList(resulType, String.class.getClassLoader());
        } else {
            resulType = null;
        }
        if (in.readByte() == 0x01) {
            locationType = new ArrayList<>();
            in.readList(locationType, String.class.getClassLoader());
        } else {
            locationType = null;
        }
        apiKey = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeString(language);
        if (resulType == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(resulType);
        }
        if (locationType == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(locationType);
        }
        dest.writeString(apiKey);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GeocodeRequestParam> CREATOR = new Parcelable.Creator<GeocodeRequestParam>() {
        @Override
        public GeocodeRequestParam createFromParcel(Parcel in) {
            return new GeocodeRequestParam(in);
        }

        @Override
        public GeocodeRequestParam[] newArray(int size) {
            return new GeocodeRequestParam[size];
        }
    };
}