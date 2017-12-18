package com.beaven.daggerstudy.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.base.BasePresenterActivity;
import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.common.AbsOnRefreshLoadMoreListener;
import com.beaven.daggerstudy.di.component.AppComponent;
import com.beaven.daggerstudy.di.component.DaggerMainComponent;
import com.beaven.daggerstudy.di.module.MainModule;
import com.beaven.daggerstudy.widget.RefreshLayoutWrapper;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

public class MainActivity extends BasePresenterActivity<MainContract.Presenter>
    implements MainContract.View {

  @BindView(R.id.recycler_main)
  RecyclerView recycler;

  @BindView(R.id.refresh_layout)
  RefreshLayoutWrapper refreshLayout;

  @Override
  protected int contentId() {
    return R.layout.activity_main;
  }

  @Override
  protected boolean hideBackUp() {
    return true;
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void inject(AppComponent appComponent) {
    DaggerMainComponent.builder()
        .appComponent(appComponent)
        .mainModule(new MainModule(this, refreshLayout))
        .build()
        .inject(this);
  }

  @Override
  protected void initView() {
    setTitleText(getResources().getString(R.string.news));
    refreshLayout.setOnRefreshLoadmoreListener(new AbsOnRefreshLoadMoreListener() {
      @Override
      public void update(RefreshLayout refreshLayout) {
        presenter.updateNews();
      }
    });
  }

  @Override
  public void setAdapter(RecyclerView.Adapter adapter) {
    recycler.setLayoutManager(new LinearLayoutManager(this));
    recycler.setHasFixedSize(true);
    recycler.setItemAnimator(new DefaultItemAnimator());
    recycler.setAdapter(adapter);
  }

  @Override
  public void startNews(int position) {
    presenter.startNews(position);
  }
}
