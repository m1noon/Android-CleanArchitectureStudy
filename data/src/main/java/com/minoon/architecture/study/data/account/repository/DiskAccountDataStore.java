package com.minoon.architecture.study.data.account.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by a13587 on 15/09/27.
 */
@Singleton
/* package */ class DiskAccountDataStore {
    private static final String TAG = DiskAccountDataStore.class.getSimpleName();

    @Inject
    public DiskAccountDataStore() {
    }
}
