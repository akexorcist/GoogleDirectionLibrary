package com.akexorcist.googledirection.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
class Geometry implements Parcelable {

    @SerializedName("location")
    private Coordination location;
    @SerializedName("location_type")
    private String locationType;
    @SerializedName("viewport")
    private Viewport viewport;

    public Geometry(){}

    public Coordination getLocation() {
        return location;
    }

    public void setLocation(Coordination location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    protected Geometry(Parcel in) {
        location = (Coordination) in.readValue(Coordination.class.getClassLoader());
        locationType = in.readString();
        viewport = (Viewport) in.readValue(Viewport.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeString(locationType);
        dest.writeValue(viewport);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Geometry> CREATOR = new Parcelable.Creator<Geometry>() {
        @Override
        public Geometry createFromParcel(Parcel in) {
            return new Geometry(in);
        }

        @Override
        public Geometry[] newArray(int size) {
            return new Geometry[size];
        }
    };
}