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

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.network.DirectionConnection;
import com.google.android.gms.maps.model.LatLng;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The class for assign the addition parameter for the request and request execution.
 *
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class DirectionRequest {
    private DirectionRequestParam param;

    public DirectionRequest(@NonNull String apiKey, @NonNull LatLng origin, @NonNull LatLng destination, @Nullable List<LatLng> waypointList) {
        param = new DirectionRequestParam().setApiKey(apiKey).setOrigin(origin).setDestination(destination).setWaypoints(waypointList);
    }

    /**
     * Assign the transport mode of the request.
     *
     * @param transportMode the language value from @see {@link com.akexorcist.googledirection.constant.TransportMode}.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest transportMode(@Nullable String transportMode) {
        param.setTransportMode(transportMode);
        return this;
    }

    /**
     * Assign the language of the request.
     *
     * @param language the language value from @see {@link com.akexorcist.googledirection.constant.Language}.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest language(@Nullable String language) {
        param.setLanguage(language);
        return this;
    }

    /**
     * Assign the unit of the request.
     *
     * @param unit the unit value from @see {@link com.akexorcist.googledirection.constant.Unit}.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest unit(@Nullable String unit) {
        param.setUnit(unit);
        return this;
    }

    /**
     * Assign the route restriction to avoid of the request.
     *
     * @param avoid the route restriction to avoid value from @see {@link com.akexorcist.googledirection.constant.AvoidType}.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest avoid(@Nullable String avoid) {
        String oldAvoid = param.getAvoid();
        if (oldAvoid != null && !oldAvoid.isEmpty()) {
            oldAvoid += "|";
        } else {
            oldAvoid = "";
        }
        oldAvoid += avoid;
        param.setAvoid(oldAvoid);
        return this;
    }

    /**
     * Assign the transit mode of the request.
     *
     * @param transitMode the transit mode value from @see {@link com.akexorcist.googledirection.constant.TransitMode}.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest transitMode(@Nullable String transitMode) {
        String oldTransitMode = param.getTransitMode();
        if (oldTransitMode != null && !oldTransitMode.isEmpty()) {
            oldTransitMode += "|";
        } else {
            oldTransitMode = "";
        }
        oldTransitMode += transitMode;
        param.setTransitMode(oldTransitMode);
        return this;
    }

    /**
     * Specifies the assumptions to use when calculating time in traffic.
     *
     * @param trafficModel the traffic model value from @see {@link com.akexorcist.googledirection.constant.TrafficModel}.
     * @return This direction request object.
     * @since 1.2.1
     */
    public DirectionRequest trafficMode(@Nullable String trafficModel) {
        param.setTrafficModel(trafficModel);
        return this;
    }

    /**
     * Specifies preferences for transit routes. Using this parameter, you can bias the
     * options returned, rather than accepting the default best route chosen by the API.
     *
     * @param transitRoutingPreference the transit routing preference value from @see {@link com.akexorcist.googledirection.constant.TransitRoutingPreference}.
     * @return This direction request object.
     * @since 1.2.1
     */
    public DirectionRequest transitRoutingPreference(@Nullable String transitRoutingPreference) {
        param.setTransitRoutingPreference(transitRoutingPreference);
        return this;
    }

    /**
     * Specifies whether require the alternative route result of the request.
     *
     * @param alternative True for include and false for exclude.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest alternativeRoute(boolean alternative) {
        param.setAlternatives(alternative);
        return this;
    }

    /**
     * Assign the departure time of the request.
     *
     * @param time The departure time.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest departureTime(@Nullable String time) {
        param.setDepartureTime(time);
        return this;
    }

    /**
     * Specifies whether require the optimized waypoint by reorder the waypoint in result.
     *
     * @param optimize True for optimize the waypoint and false for do not.
     * @return This direction request object.
     * @since 1.0.0
     */
    public DirectionRequest optimizeWaypoints(boolean optimize) {
        param.setOptimizeWaypoints(optimize);
        return this;
    }

    /**
     * Require the optimized waypoint by reorder the waypoint in result.
     *
     * @param callback Callback for the direction request.
     * @return The task for direction request.
     * @since 1.0.0
     */
    public DirectionTask execute(@Nullable final DirectionCallback callback) {
        String origin = null;
        if (param.getOrigin() != null) {
            origin = param.getOrigin().latitude + "," + param.getOrigin().longitude;
        }
        String destination = null;
        if (param.getDestination() != null) {
            destination = param.getDestination().latitude + "," + param.getDestination().longitude;
        }
        Call<Direction> direction = DirectionConnection.getInstance()
                .createService()
                .getDirection(origin,
                        destination,
                        waypointsToString(param.getWaypoints()),
                        param.getTransportMode(),
                        param.getDepartureTime(),
                        param.getLanguage(),
                        param.getUnit(),
                        param.getAvoid(),
                        param.getTransitMode(),
                        param.getTrafficModel(),
                        param.getTransitRoutingPreference(),
                        param.isAlternatives(),
                        param.getApiKey());

        direction.enqueue(new Callback<Direction>() {
            @Override
            public void onResponse(@NotNull Call<Direction> call, @NotNull Response<Direction> response) {
                if (callback != null) {
                    callback.onDirectionSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Direction> call, @NotNull Throwable t) {
                if (callback != null) {
                    callback.onDirectionFailure(t);
                }
            }
        });
        return new DirectionTask(direction);
    }

    /**
     * For internal use.
     */
    private String waypointsToString(@Nullable List<LatLng> waypoints) {
        if (waypoints != null && !waypoints.isEmpty()) {
            StringBuilder string = new StringBuilder(param.isOptimizeWaypoints() ? "optimize:true|" : "");
            string.append(waypoints.get(0).latitude).append(",").append(waypoints.get(0).longitude);
            for (int i = 1; i < waypoints.size(); i++) {
                string.append("|").append(waypoints.get(i).latitude).append(",").append(waypoints.get(i).longitude);
            }
            return string.toString();
        }
        return null;
    }
}
