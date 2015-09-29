package com.minoon.architecture.study.data.article.repository;

import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.data.article.ArticleRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by a13587 on 15/09/27.
 */
@Singleton
/* package */ class ArticleRepositoryImpl implements ArticleRepository {

    private ArticleApi api;

    private ArticleDao dao;

    @Inject
    public ArticleRepositoryImpl(ArticleApi api, ArticleDao dao) {
        this.api = api;
        this.dao = dao;
    }

    @Override
    public Observable<List<Article>> getArticleList() {
        return api.getArticleList().doOnNext(new Action1<List<Article>>() {
            @Override
            public void call(List<Article> articles) {
                // TODO save data to dao.
            }
        });
    }

    @Override
    public Observable<Article> getArticle(String id) {
        if (dao.hasArticle(id)) {
            return dao.get(id);
        }
        return api.getById(id);
    }
}
