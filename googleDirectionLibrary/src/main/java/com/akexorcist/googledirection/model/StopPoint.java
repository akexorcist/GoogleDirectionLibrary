package com.akexorcist.googledirection.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class StopPoint {
    Coordination location;
    String name;

    public Coordination getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
