package com.akexorcist.googledirection.util

import com.akexorcist.googledirection.DirectionCallback
import com.akexorcist.googledirection.model.Direction
import com.akexorcist.googledirection.request.DirectionRequest
import com.akexorcist.googledirection.request.DirectionTask


/**
 * Kotlin extension method for direction request execution.
 *
 * @param onDirectionSuccess The function of the successful direction request.
 * @param onDirectionFailure The function of the failure direction request.
 * @return The task for direction request.
 * @since 1.2.0
 */
fun DirectionRequest.execute(
    onDirectionSuccess: ((Direction) -> Unit)? = null,
    onDirectionFailure: ((Throwable) -> Unit)? = null
): DirectionTask = execute(object : DirectionCallback {
    override fun onDirectionSuccess(direction: Direction) {
        onDirectionSuccess?.invoke(direction)
    }

    override fun onDirectionFailure(t: Throwable) {
        onDirectionFailure?.invoke(t)
    }
})
