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

package com.akexorcist.googledirection.network;

import com.akexorcist.googledirection.config.GoogleDirectionConfiguration;
import com.akexorcist.googledirection.constant.ApiUrl;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class Connection {
    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    private DirectionService directionService;
    private GeocodeService geocodeService;
    private Retrofit retrofit;

    private Retrofit createRetrofit(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(ApiUrl.MAPS_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public DirectionService createDirectionService() {
        if (directionService == null) {
            directionService = createRetrofit().create(DirectionService.class);
        }
        return directionService;
    }

    public GeocodeService createGeocodeService() {
        if (geocodeService == null) {
            geocodeService = createRetrofit().create(GeocodeService.class);
        }
        return geocodeService;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = GoogleDirectionConfiguration.getInstance().getCustomClient();
        if (client != null) {
            return client;
        }
        return createDefaultClient();
    }

    private OkHttpClient createDefaultClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }
}
