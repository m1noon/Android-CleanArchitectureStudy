package com.minoon.architecture.study.data.account.repository;

import com.minoon.architecture.study.data.account.AccountRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by a13587 on 15/09/27.
 */
@Module
public class AccountRepositoryModule {
    private static final String TAG = AccountRepositoryModule.class.getSimpleName();

    @Provides
    @Singleton
    public AccountRepository provideAccountRepository(AccountRepositoryImpl repository) {
        return repository;
    }
}
