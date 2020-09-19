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
 * Traffic Model.
 *
 * @since 1.2.1
 */
public class TrafficModel {
    /**
     * (default) Indicates that the returned duration_in_traffic should be the best estimate
     * of travel time given what is known about both historical traffic conditions and live
     * traffic. Live traffic becomes more important the closer the departure_time is to now.
     *
     * @since 1.2.1
     */
    public static final String BEST_GUESS = "best_guess";
    /**
     * Indicates that the returned duration_in_traffic should be longer than the actual travel
     * time on most days, though occasional days with particularly bad traffic conditions may
     * exceed this value.
     *
     * @since 1.2.1
     */
    public static final String PESSIMISTIC = "pessimistic";
    /**
     * Indicates that the returned duration_in_traffic should be shorter than the actual travel
     * time on most days, though occasional days with particularly good traffic conditions may
     * be faster than this value.
     *
     * @since 1.2.1
     */
    public static final String OPTIMISTIC = "optimistic";
}
