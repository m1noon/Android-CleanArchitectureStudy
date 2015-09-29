package com.minoon.architecture.study.data.article.repository;

import com.minoon.architecture.study.data.article.Article;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by a13587 on 15/09/28.
 */
@Singleton
/* package */ class ArticleApi {
    private static final String TAG = ArticleApi.class.getSimpleName();

    @Inject
    public ArticleApi() {
    }

    public Observable<List<Article>> getArticleList() {
        return Observable.create(new Observable.OnSubscribe<List<Article>>() {
            @Override
            public void call(Subscriber<? super List<Article>> subscriber) {
                List<Article> articles = new ArrayList<>();
                for (int i = 0;  i < 30; i++) {
                    Article a = new Article();
                    a.id = String.valueOf(i);
                    a.title = "title-" + i;
                    a.content = i + " _ Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content " +
                            "Content Content Content Content Content Content Content Content Content Content Content Content Content ";
                    articles.add(a);
                }
                subscriber.onNext(articles);
                subscriber.onCompleted();
            }
        });
    }

    public Observable<Article> getById(final String id) {
        return Observable.create(new Observable.OnSubscribe<Article>() {
            @Override
            public void call(Subscriber<? super Article> subscriber) {
                Article article = new Article();
                article.id = id;
                article.title = "title-" + id;
                article.content = id + " _ Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content " +
                        "Content Content Content Content Content Content Content Content Content Content Content Content Content ";
                subscriber.onNext(article);
                subscriber.onCompleted();
            }
        });
    }
}
