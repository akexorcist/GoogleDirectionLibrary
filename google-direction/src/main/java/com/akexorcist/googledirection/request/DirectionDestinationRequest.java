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

package com.akexorcist.googledirection.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for assign the waypoints and destination position.
 *
 * @since 1.0.0
 */
public class DirectionDestinationRequest {
    @NonNull
    private String apiKey;
    @NonNull
    private LatLng origin;
    @Nullable
    private List<LatLng> waypointList;

    public DirectionDestinationRequest(@NonNull String apiKey, @NonNull LatLng origin) {
        this.apiKey = apiKey;
        this.origin = origin;
    }

    /**
     * Assign the waypoint position of the request
     *
     * @param waypoint The latitude and longitude of waypoint position.
     * @return This destination request object.
     * @since 1.0.0
     */
    public DirectionDestinationRequest and(@NonNull LatLng waypoint) {
        if (waypointList == null) {
            waypointList = new ArrayList<>();
        }
        waypointList.add(waypoint);
        return this;
    }

    /**
     * Assign the waypoint position of the request as a list.
     *
     * @param waypointList The list of latitude and longitude of waypoint position.
     * @return This destination request object.
     * @since 1.0.0
     */
    public DirectionDestinationRequest and(@NonNull List<LatLng> waypointList) {
        if (this.waypointList == null) {
            this.waypointList = new ArrayList<>();
        }
        this.waypointList.addAll(waypointList);
        return this;
    }

    /**
     * Assign the destination position of the request.
     *
     * @param destination The latitude and longitude of destination position.
     * @return The direction request object.
     * @since 1.0.0
     */
    public DirectionRequest to(@NonNull LatLng destination) {
        return new DirectionRequest(apiKey, origin, destination, waypointList);
    }
}
