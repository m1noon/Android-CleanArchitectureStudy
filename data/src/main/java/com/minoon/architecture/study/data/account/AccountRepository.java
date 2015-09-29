package com.minoon.architecture.study.data.account;

import rx.Observable;

/**
 * Created by a13587 on 15/09/27.
 */
public interface AccountRepository {
    Observable<Account> getAccount();
}
