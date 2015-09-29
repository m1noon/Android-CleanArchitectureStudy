package com.minoon.architecture.study.data.account.repository;

import com.minoon.architecture.study.data.account.Account;
import com.minoon.architecture.study.data.account.AccountRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by a13587 on 15/09/27.
 */
@Singleton
/* package */ class AccountRepositoryImpl implements AccountRepository {
    private static final String TAG = AccountRepositoryImpl.class.getSimpleName();

    @Inject
    public AccountRepositoryImpl(DiskAccountDataStore diskAccountDataStore) {
    }

    @Override
    public Observable<Account> getAccount() {
        return Observable.create(new Observable.OnSubscribe<Account>() {
            @Override
            public void call(Subscriber<? super Account> subscriber) {
                Account account = new Account();
                account.name = "name";
                subscriber.onNext(account);
            }
        });
    }
}
