package com.minoon.architecture.study.phone.ui.top;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.data.article.ArticleModule;
import com.minoon.architecture.study.phone.R;
import com.minoon.architecture.study.phone.ui.BaseActivity;
import com.minoon.architecture.study.phone.ui.article.ArticleDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements TopView, ArticleListAdapter.Listener {

    @Inject
    TopViewPresenter presenter;

    @Bind(R.id.a_main_rv_articles)
    RecyclerView articleList;

    TopComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        component = DaggerTopComponent.builder()
                .applicationComponent(getApplicationComponent())
                .articleModule(new ArticleModule())
                .build();
        component.inject(this);

        // set up views
        articleList.setAdapter(new ArticleListAdapter(this));
        articleList.setLayoutManager(new LinearLayoutManager(this));

        // set up data
        presenter.setView(this);
        presenter.setUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onItemClick(Article article) {
        ArticleDetailActivity.startActivity(this, article.id);
    }

    @Override
    public void addArticles(List<Article> articles) {
        ((ArticleListAdapter) articleList.getAdapter()).addArticles(articles);
    }
}
