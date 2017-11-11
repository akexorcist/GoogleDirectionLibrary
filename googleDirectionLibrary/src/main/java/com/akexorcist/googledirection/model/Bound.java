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
public class Bound implements Parcelable {
    @SerializedName("northeast")
    private Coordination northeast;
    @SerializedName("southwest")
    private Coordination southwest;

    public Bound() {
    }

    protected Bound(Parcel in) {
        northeast = in.readParcelable(Coordination.class.getClassLoader());
        southwest = in.readParcelable(Coordination.class.getClassLoader());
    }

    public Coordination getNortheastCoordination() {
        return northeast;
    }

    public void setNortheast(Coordination northeast) {
        this.northeast = northeast;
    }

    public Coordination getSouthwestCoordination() {
        return southwest;
    }

    public void setSouthwest(Coordination southwest) {
        this.southwest = southwest;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(northeast, flags);
        dest.writeParcelable(southwest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bound> CREATOR = new Creator<Bound>() {
        @Override
        public Bound createFromParcel(Parcel in) {
            return new Bound(in);
        }

        @Override
        public Bound[] newArray(int size) {
            return new Bound[size];
        }
    };
}
