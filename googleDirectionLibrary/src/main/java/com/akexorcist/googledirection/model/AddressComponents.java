package com.akexorcist.googledirection.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class AddressComponents implements Parcelable {

    @SerializedName("long_name")
    private String longName;
    @SerializedName("short_name")
    private String shortName;
    @SerializedName("types")
    private List<String> types;

    public AddressComponents(){}

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    protected AddressComponents(Parcel in) {
        longName = in.readString();
        shortName = in.readString();
        if (in.readByte() == 0x01) {
            types = new ArrayList<>();
            in.readList(types, String.class.getClassLoader());
        } else {
            types = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(longName);
        dest.writeString(shortName);
        if (types == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(types);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AddressComponents> CREATOR = new Parcelable.Creator<AddressComponents>() {
        @Override
        public AddressComponents createFromParcel(Parcel in) {
            return new AddressComponents(in);
        }

        @Override
        public AddressComponents[] newArray(int size) {
            return new AddressComponents[size];
        }
    };
}