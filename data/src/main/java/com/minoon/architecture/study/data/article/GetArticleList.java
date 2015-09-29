package com.minoon.architecture.study.data.article;

import com.minoon.architecture.study.data.PostExecutionThread;
import com.minoon.architecture.study.data.UseCase;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by a13587 on 15/09/27.
 */
public class GetArticleList extends UseCase<List<Article>> {

    ArticleRepository repository;

    @Inject
    /* package */ GetArticleList(Executor threadExecutor, PostExecutionThread postExecutionThread, ArticleRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    public void execute(Subscriber<List<Article>> subscriber) {
        subscribe(subscriber, repository.getArticleList());
    }
}
