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

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Traffic Model.
 *
 * @since 1.2.1
 */
public class TransitRoutingPreference {
    /**
     * Indicates that the calculated route should prefer limited amounts of walking.
     *
     * @since 1.2.1
     */
    public static final String LESS_WALKING = "less_walking";
    /**
     * Indicates that the calculated route should prefer a limited number of transfers.
     *
     * @since 1.2.1
     */
    public static final String FEWER_TRANSFERS = "fewer_transfers";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            LESS_WALKING,
            FEWER_TRANSFERS
    })
    public @interface Value {
    }
}
