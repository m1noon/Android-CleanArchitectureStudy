package com.minoon.architecture.study.phone.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.minoon.architecture.study.phone.app.di.ApplicationComponent;
import com.minoon.architecture.study.phone.app.MyApplication;

/**
 * Created by a13587 on 15/09/27.
 */
public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getApplication()).getApplicationComponent();
    }
}
