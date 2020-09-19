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

package com.akexorcist.googledirection.constant;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Transport mode.
 *
 * @since 1.0.0
 */
public class TransportMode {
    /**
     * (default) Indicates standard driving directions using the road network.
     *
     * @since 1.0.0
     */
    public static final String DRIVING = "driving";
    /**
     * Requests walking directions via pedestrian paths & sidewalks (where available).
     *
     * @since 1.0.0
     */
    public static final String WALKING = "walking";
    /**
     * Requests bicycling directions via bicycle paths & preferred streets (where available).
     *
     * @since 1.0.0
     */
    public static final String BICYCLING = "bicycling";
    /**
     * Requests directions via public transit routes (where available).
     *
     * @since 1.0.0
     */
    public static final String TRANSIT = "transit";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            DRIVING,
            WALKING,
            BICYCLING
    })
    public @interface Value {
    }
}
