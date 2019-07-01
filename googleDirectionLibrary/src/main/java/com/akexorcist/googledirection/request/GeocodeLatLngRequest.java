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

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class GeocodeLatLngRequest {
    private String apiKey;

    public GeocodeLatLngRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public GeocodeRequest from(LatLng origin) {
        return new GeocodeRequest(apiKey, origin);
    }
}
