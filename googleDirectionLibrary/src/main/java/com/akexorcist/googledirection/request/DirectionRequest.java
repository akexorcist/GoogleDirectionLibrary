package com.akexorcist.googledirection.request;

import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.DirectionAndPlaceConnection;
import com.akexorcist.googledirection.DirectionCallback;
import com.google.android.gms.maps.model.LatLng;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
        if(oldAvoid.isEmpty()) {
            oldAvoid = "";
        } else {
            oldAvoid += "|";
        }
        oldAvoid += avoid;
        param.setAvoid(oldAvoid);
        return this;
    }

    public DirectionRequest transitMode(String transitMode) {
        String oldTransitMode = param.getTransitMode();
        if(oldTransitMode.isEmpty()) {
            oldTransitMode = "";
        } else {
            oldTransitMode += "|";
        }
        oldTransitMode += transitMode;
        param.setTransitMode(oldTransitMode);
        return this;
    }

    public DirectionRequest alternativeRoute(boolean alternative) {
        param.setAlternatives(alternative);
        return this;
    }

    public void execute(final DirectionCallback callback) {
        Call<Direction> direction = DirectionAndPlaceConnection.createService().getDirection(param.getOrigin().latitude + "," + param.getOrigin().longitude,
                param.getDestination().latitude + "," + param.getDestination().longitude,
                param.getTransportMode(),
                param.getLanguage(),
                param.getUnit(),
                param.getAvoid(),
                param.getTransitMode(),
                param.isAlternatives(),
                param.getApiKey());

        direction.enqueue(new Callback<Direction>() {
            @Override
            public void onResponse(Response<Direction> response, Retrofit retrofit) {
                callback.onDirectionSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onDirectionFailure(t);
            }
        });
    }
}
