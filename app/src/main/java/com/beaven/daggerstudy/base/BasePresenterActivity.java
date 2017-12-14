package com.beaven.daggerstudy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.beaven.daggerstudy.app.BaseApp;
import com.beaven.daggerstudy.di.component.AppComponent;
import javax.inject.Inject;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:45
 */

public abstract class BasePresenterActivity<T extends BaseContract.Presenter> extends BaseActivity
    implements BaseContract.View {

  @Inject
  protected T presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initData();
    inject(BaseApp.getAppComponent());
    initView();
    presenter.onCreate();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  /**
   * 初始化Data
   */
  protected abstract void initData();

  /**
   * 依赖注入
   *
   * @param appComponent 全局Component
   */
  protected abstract void inject(AppComponent appComponent);

  /**
   * 初始化View
   */
  protected abstract void initView();

  @Override
  public void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showContentEmpty() {

  }

  @Override
  public void showContentError() {

  }

  @Override
  public void showLoading(String msg) {

  }

  @Override
  public void showContent() {

  }

  @Override
  public Context getContext() {
    return this;
  }
}
