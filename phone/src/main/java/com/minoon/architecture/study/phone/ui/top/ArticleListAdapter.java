package com.minoon.architecture.study.phone.ui.top;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minoon.architecture.study.data.article.Article;
import com.minoon.architecture.study.phone.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by a13587 on 15/09/28.
 */
/* package */ class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleListViewHolder> {
    private static final String TAG = ArticleListAdapter.class.getSimpleName();

    interface Listener {
        void onItemClick(Article article);
    }

    private final List<Article> dataSet;

    private final Listener listener;

    public ArticleListAdapter(Listener listener) {
        dataSet = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public ArticleListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.cell_article_list, null, false);
        final ArticleListViewHolder holder = new ArticleListViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(dataSet.get(holder.getAdapterPosition()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleListViewHolder holder, int i) {
        Article a = dataSet.get(i);
        holder.title.setText(a.title);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addArticles(List<Article> articles) {
        final int addSize = articles == null ? 0 : articles.size();
        if (addSize > 0) {
            final int size = dataSet.size();
            dataSet.addAll(articles);
            notifyItemRangeInserted(size, addSize);
        }
    }

    /* package */ class ArticleListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.cell_article_list_tv_title)
        TextView title;

        public ArticleListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
