package com.minoon.architecture.study.data.article;

import com.minoon.architecture.study.data.PostExecutionThread;
import com.minoon.architecture.study.data.UseCase;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by a13587 on 15/09/28.
 */
public class GetArticle extends UseCase<Article> {
    private static final String TAG = GetArticle.class.getSimpleName();

    ArticleRepository repository;

    @Inject
    public GetArticle(Executor threadExecutor, PostExecutionThread postExecutionThread, ArticleRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    public void execute(String id, Subscriber<Article> subscriber) {
        Observable<Article> articleObservable = repository.getArticle(id);
        subscribe(subscriber, articleObservable);
    }
}
