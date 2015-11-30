package com.akexorcist.googledirection;

import com.akexorcist.googledirection.model.Direction;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public interface DirectionCallback {
    void onDirectionSuccess(Direction direction);
    void onDirectionFailure(Throwable t);
}
