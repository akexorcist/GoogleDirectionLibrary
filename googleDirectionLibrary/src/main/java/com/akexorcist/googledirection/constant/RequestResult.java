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

package com.akexorcist.googledirection.constant;

/**
 * The status of the request, and may contain debugging information to
 * help you track down why the Directions service failed.
 */
public class RequestResult {
    /**
     * Indicates the response contains a valid result.
     * @since 1.0
     */
    public static final String OK = "OK";
    /**
     * Indicates at least one of the locations specified in the request's origin,
     * destination, or waypoints could not be geocoded.
     * @since 1.0
     */
    public static final String NOT_FOUND = "NOT_FOUND";
    /**
     * Indicates no route could be found between the origin and destination.
     * @since 1.0
     */
    public static final String ZERO_RESULTS = "ZERO_RESULTS";
    /**
     * Indicates that too many waypoints were provided in the request.
     * @since 1.0
     */
    public static final String MAX_WAYPOINTS_EXCEEDED = "MAX_WAYPOINTS_EXCEEDED";
    /**
     * Indicates the requested route is too long and cannot be processed.
     * This error occurs when more complex directions are returned.
     * Try reducing the number of waypoints, turns, or instructions.
     * @since 1.0
     */
    public static final String MAX_ROUTE_LENGTH_EXCEEDED = "MAX_ROUTE_LENGTH_EXCEEDED";
    /**
     * Indicates that the provided request was invalid. Common causes of
     * this status include an invalid parameter or parameter value.
     * @since 1.0
     */
    public static final String INVALID_REQUEST = "INVALID_REQUEST";
    /**
     * Indicates any of the following:
     * <BR />• The API key is missing or invalid.
     * <BR />• Billing has not been enabled on your account.
     * <BR />• A self-imposed usage cap has been exceeded.
     * <BR />• The provided method of payment is no longer valid (for example, a credit card has expired).
     * @since 1.0
     */
    public static final String OVER_DAILY_LIMIT = "OVER_QUERY_LIMIT";
    /**
     * Indicates the service has received too many requests from
     * your application within the allowed time period.
     * @since 1.0
     */
    public static final String OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
    /**
     * Indicates that the service denied use of the directions service by your application.
     * @since 1.0
     */
    public static final String REQUEST_DENIED = "REQUEST_DENIED";
    /**
     * Indicates a directions request could not be processed due to
     * a server error. The request may succeed if you try again.
     * @since 1.0
     */
    public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
}
