package com.minoon.architecture.study.phone.app;

import android.app.Application;

import com.minoon.architecture.study.phone.app.di.ApplicationComponent;
import com.minoon.architecture.study.phone.app.di.ApplicationModule;
import com.minoon.architecture.study.phone.app.di.DaggerApplicationComponent;


/**
 * Created by a13587 on 15/09/27.
 */
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
