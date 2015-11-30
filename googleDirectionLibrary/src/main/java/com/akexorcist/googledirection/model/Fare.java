package com.akexorcist.googledirection.model;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */

@Parcel(parcelsIndex = false)
public class Fare {
    String currency;
    String value;
    String text;

    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
