package com.minoon.architecture.study.data.article.repository;

import com.minoon.architecture.study.data.article.ArticleRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by a13587 on 15/09/27.
 */
@Module
public class ArticleRepositoryModule {

    @Singleton
    @Provides
    public ArticleRepository provideArticleRepository(ArticleRepositoryImpl articleRepository) {
        return articleRepository;
    }
}
