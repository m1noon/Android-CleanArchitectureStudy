package com.minoon.architecture.study.phone.ui.article;

import com.minoon.architecture.study.data.DefaultSubscriber;
import com.minoon.architecture.study.data.account.Account;
import com.minoon.architecture.study.data.account.GetAccount;
import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.data.article.GetArticle;
import com.minoon.architecture.study.phone.app.di.PerActivity;
import com.minoon.architecture.study.phone.ui.Presenter;

import javax.inject.Inject;

/**
 * Created by a13587 on 15/09/27.
 */
@PerActivity
/* package */ class ArticleDetailViewPresenter implements Presenter {
    private static final String TAG = ArticleDetailViewPresenter.class.getSimpleName();

    String id;

    GetAccount getAccount;

    GetArticle getArticle;

    ArticleDetailView view;

    @Inject
    ArticleDetailViewPresenter(GetAccount getAccount, GetArticle getArticle) {
        this.getAccount = getAccount;
        this.getArticle = getArticle;
    }


    @Override
    public void resume() {/* Do nothing */}

    @Override
    public void pause() {/* Do nothing */}

    @Override
    public void destroy() {
        this.getAccount.unsubscribe();
    }

    public void setView(ArticleDetailView view) {
        this.view = view;
    }

    //// for Controller Process

    public void setId(String id) {
        this.id = id;
    }

    public void setUp() {
        getAccount.execute(new GetAccountSubscriber());
        getArticle.execute(id, new GetArticleSubscriber());
    }



    //// for Presenter Process


    private final class GetAccountSubscriber extends DefaultSubscriber<Account> {
        @Override
        public void onNext(Account account) {
            view.setAccountName(account.name);
        }
    }

    private final class GetArticleSubscriber extends DefaultSubscriber<Article> {
        @Override
        public void onNext(Article article) {
            view.setArticle(article);
        }
    }
}
