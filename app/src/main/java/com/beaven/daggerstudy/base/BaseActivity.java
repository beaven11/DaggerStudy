package com.beaven.daggerstudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.beaven.daggerstudy.R;

/**
 * @author : Beaven
 * @date : 2017/12/9 14:53
 */
public abstract class BaseActivity extends AppCompatActivity {

    private LinearLayout rootLayout;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        setContentView(contentId());
        unbinder = ButterKnife.bind(this);
        initTitleBar();
    }

    @Override
    public void setContentView(View view) {
        rootLayout = findViewById(R.id.layout_root);
        if (rootLayout == null) {
            return;
        }
        ViewGroup.LayoutParams params =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        rootLayout.addView(view, params);
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initTitleBar() {
        Toolbar toolbar = rootLayout.findViewById(R.id.toolbar);
        if (hideTitleBar()) {
            toolbar.setVisibility(View.GONE);
            return;
        }
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && !hideBackUp()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract int contentId();

    protected boolean hideTitleBar() {
        return false;
    }

    protected boolean hideBackUp() {
        return false;
    }

    protected void setTitleText(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
