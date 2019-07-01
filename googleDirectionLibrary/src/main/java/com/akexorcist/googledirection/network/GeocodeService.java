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

import com.akexorcist.googledirection.constant.ApiUrl;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Geocode;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public interface GeocodeService {

    @GET(ApiUrl.GEOCODE_API_URL)
    Call<Geocode> getDirection(@Query("latlng") String origin,
                                 @Query("language") String language,
                                 @Query("result_type") String resultType,
                                 @Query("location_type") String locationType,
                                 @Query("key") String apiKey);
    @GET(ApiUrl.GEOCODE_API_URL)
    Single<Geocode> getDirectionRx(@Query("latlng") String origin,
                                   @Query("language") String language,
                                   @Query("result_type") String resultType,
                                   @Query("location_type") String locationType,
                                   @Query("key") String apiKey);
}
