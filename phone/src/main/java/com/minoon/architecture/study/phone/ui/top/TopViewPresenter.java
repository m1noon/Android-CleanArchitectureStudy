package com.minoon.architecture.study.phone.ui.top;

import com.minoon.architecture.study.data.DefaultSubscriber;
import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.data.article.GetArticleList;
import com.minoon.architecture.study.phone.app.di.PerActivity;
import com.minoon.architecture.study.phone.ui.Presenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by a13587 on 15/09/28.
 */
@PerActivity
/* package */ class TopViewPresenter implements Presenter {
    private static final String TAG = TopViewPresenter.class.getSimpleName();

    TopView view;

    GetArticleList getArticleList;

    @Inject
    /* package */ TopViewPresenter(GetArticleList getArticleList) {
        this.getArticleList = getArticleList;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        getArticleList.unsubscribe();
    }

    public void setView(TopView view) {
        this.view = view;
    }

    public void setUp() {
        getArticleList.execute(new GetArticleListSubscriber());
    }

    private final class GetArticleListSubscriber extends DefaultSubscriber<List<Article>> {
        @Override
        public void onNext(List<Article> articles) {
            view.addArticles(articles);
        }
    }
}
