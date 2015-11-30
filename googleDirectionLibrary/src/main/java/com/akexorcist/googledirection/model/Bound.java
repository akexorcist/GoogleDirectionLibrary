package com.akexorcist.googledirection.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Bound {
    Coordination northeast;
    Coordination southwest;

    public Coordination getNortheastCoordination() {
        return northeast;
    }

    public Coordination getSouthwestCoordination() {
        return southwest;
    }
}
