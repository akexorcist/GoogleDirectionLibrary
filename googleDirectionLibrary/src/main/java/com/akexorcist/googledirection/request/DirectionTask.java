package com.akexorcist.googledirection.request;

import com.akexorcist.googledirection.model.Direction;

import retrofit2.Call;

/**
 * Created by Akexorcist on 11/10/2017 AD.
 */

public class DirectionTask {
    private Call<Direction> directionCall;

    public DirectionTask(Call<Direction> directionCall) {
        this.directionCall = directionCall;
    }

    public void cancel() {
        if (directionCall != null && !directionCall.isCanceled()) {
            directionCall.cancel();
        }
    }

    public boolean isFinished() {
        return directionCall != null && directionCall.isExecuted();
    }

    public Call<Direction> toRetrofitCall() {
        return directionCall;
    }
}
