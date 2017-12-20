package com.beaven.daggerstudy.base;

import android.content.Context;
import android.support.annotation.NonNull;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:50
 */

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {

  protected final V baseView;
  protected final CompositeDisposable disposable;

  public BasePresenter(@NonNull V baseView) {
    this.baseView = baseView;
    this.disposable = new CompositeDisposable();
  }

  @Override
  public void onCreate() {

  }

  @Override
  public void onResume() {

  }

  @Override
  public void onPause() {

  }

  @Override
  public void onDestroy() {
    disposable.clear();
  }

  @Override
  public Context getContext() {
    return baseView.getContext();
  }
}
