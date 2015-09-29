package com.minoon.architecture.study.phone.ui.article;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.minoon.architecture.study.data.account.AccountModule;
import com.minoon.architecture.study.data.article.ArticleModule;
import com.minoon.architecture.study.phone.R;
import com.minoon.architecture.study.phone.app.di.ComponentHolder;
import com.minoon.architecture.study.phone.ui.BaseActivity;

public class ArticleDetailActivity extends BaseActivity implements ComponentHolder<ArticleComponent> {

    private static final String EXTRA_ARTICLE_ID = "extra_article_id";

    private ArticleComponent component;

    public static void startActivity(Context context, String id) {
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        intent.putExtra(EXTRA_ARTICLE_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            String id = intent.getStringExtra(EXTRA_ARTICLE_ID);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.a_article_detail_fl_container, ArticleDetailFragment.newInstance(id))
                    .commit();
        }

        component = DaggerArticleComponent.builder()
                .applicationComponent(getApplicationComponent())
                .accountModule(new AccountModule())
                .articleModule(new ArticleModule())
                .build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public ArticleComponent getComponent() {
        return component;
    }
}
