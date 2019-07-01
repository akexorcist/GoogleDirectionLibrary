package com.akexorcist.googledirection.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

class Viewport implements Parcelable {

    @SerializedName("southwest")
    private Coordination southwest;
    @SerializedName("northeast")
    private Coordination northeast;

    public Viewport() {}

    public Coordination getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Coordination southwest) {
        this.southwest = southwest;
    }

    public Coordination getNortheast() {
        return northeast;
    }

    public void setNortheast(Coordination northeast) {
        this.northeast = northeast;
    }

    protected Viewport(Parcel in) {
        southwest = (Coordination) in.readValue(Coordination.class.getClassLoader());
        northeast = (Coordination) in.readValue(Coordination.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(southwest);
        dest.writeValue(northeast);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Viewport> CREATOR = new Parcelable.Creator<Viewport>() {
        @Override
        public Viewport createFromParcel(Parcel in) {
            return new Viewport(in);
        }

        @Override
        public Viewport[] newArray(int size) {
            return new Viewport[size];
        }
    };
}