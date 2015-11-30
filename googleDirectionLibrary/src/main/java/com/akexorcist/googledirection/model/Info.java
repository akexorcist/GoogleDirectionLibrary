package com.akexorcist.googledirection.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Info {
    String text;
    String value;

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
