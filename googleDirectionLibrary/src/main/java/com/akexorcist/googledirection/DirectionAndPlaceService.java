package com.akexorcist.googledirection;

import com.akexorcist.googledirection.constant.DirectionUrl;
import com.akexorcist.googledirection.model.Direction;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public interface DirectionAndPlaceService {

    @GET(DirectionUrl.DIRECTION_API_URL)
    Call<Direction> getDirection(@Query("origin") String origin,
                                 @Query("destination") String destination,
                                 @Query("mode") String transportMode,
                                 @Query("language") String language,
                                 @Query("units") String units,
                                 @Query("avoid") String avoid,
                                 @Query("transit_mode") String transitMode,
                                 @Query("alternatives") boolean alternatives,
                                 @Query("key") String apiKey);
}
