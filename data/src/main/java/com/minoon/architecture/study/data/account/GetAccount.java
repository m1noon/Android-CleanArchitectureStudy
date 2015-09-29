package com.minoon.architecture.study.data.account;

import com.minoon.architecture.study.data.PostExecutionThread;
import com.minoon.architecture.study.data.UseCase;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by a13587 on 15/09/27.
 */
public class GetAccount extends UseCase<Account> {
    private static final String TAG = GetAccount.class.getSimpleName();

    private final AccountRepository accountRepository;

    @Inject
    /* package */ GetAccount(Executor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.accountRepository = repository;
    }

    public void execute(Subscriber<Account> accountSubscriber) {
        subscribe(accountSubscriber, accountRepository.getAccount());
    }

}
