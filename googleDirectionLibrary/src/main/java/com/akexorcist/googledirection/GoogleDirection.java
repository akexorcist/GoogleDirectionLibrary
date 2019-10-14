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

package com.akexorcist.googledirection;

import com.akexorcist.googledirection.request.DirectionOriginRequest;

/**
 * Initiate class for direction request of the Google Direction API.
 *
 * @since 1.0.0
 */
public class GoogleDirection {
    /**
     * Create the Google Direction with Google Direction API Key.
     * <BR />
     * <B>Notes</B> - Do not put your Web API Key in the code directly.
     * The key may be stole and misused by malicious parties.
     *
     * @param apiKey Web API Key for the Google Direction API
     * @return The origin request object
     * @since 1.0.0
     */
    public static DirectionOriginRequest withServerKey(String apiKey) {
        return new DirectionOriginRequest(apiKey);
    }
}
