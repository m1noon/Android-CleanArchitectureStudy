package com.minoon.architecture.study.data.article;

import java.util.List;

import rx.Observable;

/**
 * Created by a13587 on 15/09/27.
 */
public interface ArticleRepository {

    Observable<List<Article>> getArticleList();

    Observable<Article> getArticle(String id);
}
