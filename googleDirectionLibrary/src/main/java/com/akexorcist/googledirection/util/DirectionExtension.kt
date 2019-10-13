package com.akexorcist.googledirection.util

import com.akexorcist.googledirection.DirectionCallback
import com.akexorcist.googledirection.model.Direction
import com.akexorcist.googledirection.request.DirectionRequest
import com.akexorcist.googledirection.request.DirectionTask

fun DirectionRequest.execute(
    onDirectionSuccess: ((Direction, String) -> Unit)? = null,
    onDirectionFailure: ((Throwable) -> Unit)? = null
): DirectionTask = execute(object : DirectionCallback {
    override fun onDirectionSuccess(direction: Direction, rawBody: String) {
        onDirectionSuccess?.invoke(direction, rawBody)
    }

    override fun onDirectionFailure(t: Throwable) {
        onDirectionFailure?.invoke(t)
    }
})
