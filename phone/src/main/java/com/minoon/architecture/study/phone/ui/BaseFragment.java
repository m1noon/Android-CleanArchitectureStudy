package com.minoon.architecture.study.phone.ui;

import android.support.v4.app.Fragment;

import com.minoon.architecture.study.phone.app.di.ComponentHolder;

/**
 * Created by a13587 on 15/09/27.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((ComponentHolder<C>)getActivity()).getComponent());
    }
}
