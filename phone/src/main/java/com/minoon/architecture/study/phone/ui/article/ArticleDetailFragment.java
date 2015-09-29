package com.minoon.architecture.study.phone.ui.article;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.phone.R;
import com.minoon.architecture.study.phone.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArticleDetailFragment extends BaseFragment implements ArticleDetailView {

    private static final String ARG_ARTICLE_ID = "arg_article_id";

    @Inject
    ArticleDetailViewPresenter presenter;

    @Bind(R.id.f_article_detail_tv_name)
    TextView accountNameView;
    @Bind(R.id.f_article_detail_tv_title)
    TextView title;
    @Bind(R.id.f_article_detail_tv_content)
    TextView content;

    public static ArticleDetailFragment newInstance(String id) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ARTICLE_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(ArticleComponent.class).inject(this);
        presenter.setView(this);
        presenter.setId(getArguments().getString(ARG_ARTICLE_ID));
        presenter.setUp();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }


    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroyView();
        presenter.destroy();
    }

    @Override
    public void setAccountName(String name) {
        accountNameView.setText(name);
    }

    @Override
    public void setArticle(Article article) {
        title.setText(article.title);
        content.setText(article.content);
    }
}
