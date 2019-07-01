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

import com.akexorcist.googledirection.GeocodeCallback;
import com.akexorcist.googledirection.model.Geocode;
import com.akexorcist.googledirection.network.Connection;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeocodeRequest {
    private GeocodeRequestParam param;

    public GeocodeRequest(String apiKey, LatLng origin) {
        param = new GeocodeRequestParam().setApiKey(apiKey).setLocation(origin);
    }

    public GeocodeRequest language(String language) {
        param.setLanguage(language);
        return this;
    }

    public Task<Geocode> execute(final GeocodeCallback callback) {
        Call<Geocode> geocode = Connection.getInstance()
                .createGeocodeService()
                .getDirection(param.getLocation().latitude + "," + param.getLocation().longitude,
                        param.getLanguage(),
                        listToString(param.getResulType()),
                        listToString(param.getLocationType()),
                        param.getApiKey());

        geocode.enqueue(new Callback<Geocode>() {
            @Override
            public void onResponse(Call<Geocode> call, Response<Geocode> response) {
                if (callback != null) {
                    callback.onGeocodeSuccess(response.body(), new Gson().toJson(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Geocode> call, Throwable t) {
                callback.onGeocodeFailure(t);
            }
        });
        return new Task<>(geocode);
    }

    public Single<Geocode> request() {
        return Connection.getInstance()
                .createGeocodeService()
                .getDirectionRx(param.getLocation().latitude + "," + param.getLocation().longitude,
                        param.getLanguage(),
                        listToString(param.getResulType()),
                        listToString(param.getLocationType()),
                        param.getApiKey());

    }

    private String listToString(List<String> resultType) {
        if (resultType != null && !resultType.isEmpty()) {
            StringBuilder string = new StringBuilder();
            string.append(resultType.get(0));
            for (int i = 1; i < resultType.size(); i++) {
                string.append("|").append(resultType.get(i));
            }
            return string.toString();
        }
        return null;
    }

}
