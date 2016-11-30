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

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.network.DirectionConnection;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionRequest {
    protected DirectionRequestParam param;

    public DirectionRequest(String apiKey, LatLng origin, LatLng destination) {
        param = new DirectionRequestParam().setApiKey(apiKey).setOrigin(origin).setDestination(destination);
    }

    public DirectionRequest transportMode(String transportMode) {
        param.setTransportMode(transportMode);
        return this;
    }

    public DirectionRequest language(String language) {
        param.setLanguage(language);
        return this;
    }

    public DirectionRequest unit(String unit) {
        param.setUnit(unit);
        return this;
    }

    public DirectionRequest avoid(String avoid) {
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

    public DirectionRequest transitMode(String transitMode) {
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

    public DirectionRequest alternativeRoute(boolean alternative) {
        param.setAlternatives(alternative);
        return this;
    }

    public DirectionRequest departureTime(String time) {
        param.setDepartureTime(time);
        return this;
    }

    public DirectionRequest waypoints(List<LatLng> waypoints) {
        param.setWaypoints(waypoints);
        return this;
    }

    public DirectionRequest optimizeWaypoints(boolean optimize) {
        param.setOptimizeWaypoints(optimize);
        return this;
    }

    public void execute(final DirectionCallback callback) {
        Call<Direction> direction = DirectionConnection.getInstance()
                .createService()
                .getDirection(param.getOrigin().latitude + "," + param.getOrigin().longitude,
                        param.getDestination().latitude + "," + param.getDestination().longitude,
                        waypointsToString(param.getWaypoints()),
                        param.getTransportMode(),
                        param.getDepartureTime(),
                        param.getLanguage(),
                        param.getUnit(),
                        param.getAvoid(),
                        param.getTransitMode(),
                        param.isAlternatives(),
                        param.getApiKey());

        direction.enqueue(new Callback<Direction>() {
            @Override
            public void onResponse(Call<Direction> call, Response<Direction> response) {
                if (callback != null) {
                    callback.onDirectionSuccess(response.body(), new Gson().toJson(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Direction> call, Throwable t) {
                callback.onDirectionFailure(t);
            }
        });
    }

    private String waypointsToString(List<LatLng> waypoints) {
        if (waypoints != null && !waypoints.isEmpty()) {
            String string = param.isOptimizeWaypoints() ? "optimize:true|" : "";
            string += waypoints.get(0).latitude + "," + waypoints.get(0).longitude;
            for (int i = 1; i < waypoints.size(); i++) {
                string += "|" + waypoints.get(i).latitude + "," + waypoints.get(i).longitude;
            }
            return string;
        }
        return null;
    }
}
