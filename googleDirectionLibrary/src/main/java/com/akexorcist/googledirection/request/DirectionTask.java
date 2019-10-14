package com.akexorcist.googledirection.request;

import com.akexorcist.googledirection.model.Direction;

import retrofit2.Call;

/**
 * Direction request task that given from execution of {@link DirectionRequest}.
 * For handle the request task when the request has started.
 *
 * @since 1.0.0
 */

public class DirectionTask {
    private Call<Direction> directionCall;

    public DirectionTask(Call<Direction> directionCall) {
        this.directionCall = directionCall;
    }

    /**
     * Cancel the task of direction request if currently running.
     *
     * @since 1.0.0
     */
    public void cancel() {
        if (directionCall != null && !directionCall.isCanceled()) {
            directionCall.cancel();
        }
    }

    /**
     * Check the direction request task completion.
     *
     * @return True for finished and false for unfinished.
     * @since 1.0.0
     */
    public boolean isFinished() {
        return directionCall != null && directionCall.isExecuted();
    }

    /**
     * Get the Retrofit's call object of the direction request.
     *
     * @return The {@link Call} object of direction request.
     * @since 1.0.0
     */
    public Call<Direction> toRetrofitCall() {
        return directionCall;
    }
}
