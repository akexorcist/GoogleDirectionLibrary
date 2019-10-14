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

import com.akexorcist.googledirection.model.Direction;

/**
 * Interface for the response from the direction request of the Google Direction API.
 *
 * @since 1.0.0
 */
public interface DirectionCallback {
    /**
     * Retrieve the response from direction request successfully.
     *
     * @param direction The direction result from the Google Direction API
     * @since 1.0.0
     */
    void onDirectionSuccess(Direction direction);

    /**
     * Retrieve the response from direction request with error result.
     *
     * @param t A throwable from the response of Google Direction API.
     * @since 1.0.0
     */
    void onDirectionFailure(Throwable t);
}
