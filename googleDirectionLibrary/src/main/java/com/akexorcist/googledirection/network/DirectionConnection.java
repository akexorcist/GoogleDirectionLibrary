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
import com.akexorcist.googledirection.constant.DirectionUrl;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionConnection {
    private static DirectionConnection connection;

    public static DirectionConnection getInstance() {
        if (connection == null) {
            connection = new DirectionConnection();
        }
        return connection;
    }

    private DirectionService service;

    public DirectionService createService() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(DirectionUrl.MAPS_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(DirectionService.class);
        }
        return service;
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
        if (GoogleDirectionConfiguration.getInstance().isLogEnabled()) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder.build();
    }
}
