package com.beaven.daggerstudy.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.base.BasePresenterActivity;
import com.beaven.daggerstudy.base.contract.NewsContract;
import com.beaven.daggerstudy.di.component.AppComponent;
import com.beaven.daggerstudy.di.component.DaggerNewsComponent;
import com.beaven.daggerstudy.di.module.NewsModule;
import com.beaven.daggerstudy.presenter.main.MainPresenter;

public class NewsActivity extends BasePresenterActivity<NewsContract.Presenter>
    implements NewsContract.View {

  public static final String NEWS_TYPE_INDEX = "news_type_index";

  public static void start(Context context, int index) {
    Intent intent = new Intent(context, NewsActivity.class);
    intent.putExtra(NEWS_TYPE_INDEX, index);
    context.startActivity(intent);
  }

  @BindView(R.id.recycler_news)
  RecyclerView recycler;

  private int index;

  @Override
  protected int contentId() {
    return R.layout.activity_news;
  }

  @Override
  protected void initData() {
    index = getIntent().getIntExtra(NEWS_TYPE_INDEX, 0);
  }

  @Override
  protected void inject(AppComponent appComponent) {
    DaggerNewsComponent.builder()
        .appComponent(appComponent)
        .newsModule(new NewsModule(this, MainPresenter.typeQuerys[index]))
        .build()
        .inject(this);
  }

  @Override
  protected void initView() {
    setTitleText(MainPresenter.typeItems[index]);
  }

  @Override
  public void setAdapter(RecyclerView.Adapter adapter) {
    recycler.setLayoutManager(new LinearLayoutManager(this));
    recycler.setHasFixedSize(true);
    recycler.setItemAnimator(new DefaultItemAnimator());
    recycler.setAdapter(adapter);
  }
}
