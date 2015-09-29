package com.minoon.architecture.study.phone.ui.top;

import com.minoon.architecture.study.data.article.ArticleModule;
import com.minoon.architecture.study.phone.app.di.ApplicationComponent;
import com.minoon.architecture.study.phone.app.di.PerActivity;

import dagger.Component;

/**
 * Created by a13587 on 15/09/27.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ArticleModule.class
        }
)
/* package */ interface TopComponent {

    void inject(MainActivity activity);
}
