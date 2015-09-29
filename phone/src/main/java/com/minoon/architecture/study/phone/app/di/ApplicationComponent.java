package com.minoon.architecture.study.phone.app.di;

import android.content.Context;

import com.minoon.architecture.study.data.PostExecutionThread;
import com.minoon.architecture.study.data.account.AccountRepository;
import com.minoon.architecture.study.data.article.ArticleRepository;
import com.minoon.architecture.study.phone.app.di.data.RepositoryModule;
import com.minoon.architecture.study.phone.ui.BaseActivity;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by a13587 on 15/09/27.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                RepositoryModule.class
        }
)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    // Exposed to sub-graphs.
    Context context();
    Executor executor();
    PostExecutionThread postExecutionThread();
    AccountRepository accountRepository();
    ArticleRepository articleRepository();
}
