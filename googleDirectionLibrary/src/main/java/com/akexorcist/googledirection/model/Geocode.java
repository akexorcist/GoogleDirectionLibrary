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

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Geocode implements Parcelable {
    @SerializedName("results")
    private List<Result> results;
    @SerializedName("status")
    private String status;
    @SerializedName("error_message")
    private String errorMessage;

    public Geocode() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    protected Geocode(Parcel in) {
        if (in.readByte() == 0x01) {
            results = new ArrayList<>();
            in.readList(results, Route.class.getClassLoader());
        } else {
            results = null;
        }
        status = in.readString();
        errorMessage = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (results == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(results);
        }
        dest.writeString(status);
        dest.writeString(errorMessage);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Geocode> CREATOR = new Parcelable.Creator<Geocode>() {
        @Override
        public Geocode createFromParcel(Parcel in) {
            return new Geocode(in);
        }

        @Override
        public Geocode[] newArray(int size) {
            return new Geocode[size];
        }
    };
}