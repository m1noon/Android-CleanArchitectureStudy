package com.minoon.architecture.study.phone.app.di.data;

import com.minoon.architecture.study.data.PostExecutionThread;
import com.minoon.architecture.study.data.account.repository.AccountRepositoryModule;
import com.minoon.architecture.study.data.article.repository.ArticleRepositoryModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by a13587 on 15/09/28.
 */
@Module(
        includes = {
                AccountRepositoryModule.class,
                ArticleRepositoryModule.class
        }
)
public class RepositoryModule {
    private static final String TAG = RepositoryModule.class.getSimpleName();

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    public Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }
}
