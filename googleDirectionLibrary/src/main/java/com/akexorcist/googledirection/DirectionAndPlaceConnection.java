package com.akexorcist.googledirection;

import com.akexorcist.googledirection.constant.DirectionUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionAndPlaceConnection {
    private static DirectionAndPlaceService service;
    public static DirectionAndPlaceService createService() {
        if(service == null) {
            OkHttpClient client = new OkHttpClient();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DirectionUrl.MAPS_API_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(DirectionAndPlaceService.class);
        }
        return service;
    }
}
