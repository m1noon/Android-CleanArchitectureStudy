package com.minoon.architecture.study.data;

import rx.Subscriber;

/**
 * Created by a13587 on 15/09/27.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {
    private static final String TAG = DefaultSubscriber.class.getSimpleName();

    @Override
    public void onCompleted() {/* Do nothing */}

    @Override
    public void onError(Throwable e) {/* Do nothing */}

    @Override
    public void onNext(T t) {/* Do nothing */}
}
