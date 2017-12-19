package com.beaven.daggerstudy.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.base.BasePresenterActivity;
import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.common.AbsOnRefreshLoadMoreListener;
import com.beaven.daggerstudy.di.component.AppComponent;
import com.beaven.daggerstudy.di.component.DaggerMainComponent;
import com.beaven.daggerstudy.di.module.MainModule;
import com.beaven.daggerstudy.widget.MultipleStatusView;
import com.beaven.daggerstudy.widget.RefreshLayoutWrapper;
import com.beaven.daggerstudy.widget.dialog.DialogLoading;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

public class MainActivity extends BasePresenterActivity<MainContract.Presenter>
    implements MainContract.View {

  @BindView(R.id.recycler_main)
  RecyclerView recycler;

  @BindView(R.id.refresh_layout)
  RefreshLayoutWrapper refreshLayout;

  @BindView(R.id.status_view)
  MultipleStatusView statusView;

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

  @OnClick({ R.id.button_content, R.id.button_empty, R.id.button_error, R.id.button_loading })
  public void onClick(View view) {
    int id = view.getId();
    switch (id) {
      case R.id.button_content:
        statusView.showContent();
        break;
      case R.id.button_empty:
        statusView.showEmpty();
        break;
      case R.id.button_error:
        statusView.showError();
        break;
      case R.id.button_loading:
        //statusView.showLoading();
        DialogLoading.dialogLoading().show(this);
        break;
      default:
        break;
    }
  }
}
