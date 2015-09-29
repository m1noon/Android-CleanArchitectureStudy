package com.minoon.architecture.study.data.article.repository;

import com.minoon.architecture.study.data.article.Article;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by a13587 on 15/09/28.
 */
@Singleton
/* package */ class ArticleDao {
    private static final String TAG = ArticleDao.class.getSimpleName();

    @Inject
    public ArticleDao() {
    }

    public Observable<Article> get(final String id) {

        return Observable.create(new Observable.OnSubscribe<Article>() {
            @Override
            public void call(Subscriber<? super Article> subscriber) {
                // TODO get from data store.
                Article article = new Article();
                article.id = id;
                subscriber.onNext(article);
                subscriber.onCompleted();
            }
        });
    }

    public void putArticleList(List<Article> articleList) {
        // TODO save data to disc
    }

    public boolean hasArticle(String id) {
        // TODO check data store
        return false;
    }
}
