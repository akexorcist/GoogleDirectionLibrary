package com.akexorcist.googledirection.request;

import retrofit2.Call;

/**
 * Created by Akexorcist on 11/10/2017 AD.
 */

public class Task<T> {
    private Call<T> call;

    public Task(Call<T> call) {
        this.call = call;
    }

    public void cancel() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

    public boolean isFinished() {
        return call != null && call.isExecuted();
    }

    public Call<T> toRetrofitCall() {
        return call;
    }
}
