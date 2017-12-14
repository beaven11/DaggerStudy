package com.beaven.daggerstudy.presenter.main;

import android.support.annotation.NonNull;
import com.beaven.daggerstudy.base.BasePresenter;
import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.view.NewsActivity;
import java.util.Arrays;
import javax.inject.Inject;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:54
 */

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  public static final String[] typeItems = { "头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经" };

  public static final String[] typeQuerys =
      { "top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing" };

  private NewsTypeAdapter adapter;

  @Inject
  public MainPresenter(@NonNull MainContract.View baseView, NewsTypeAdapter adapter) {
    super(baseView);
    this.adapter = adapter;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    baseView.setAdapter(adapter);
    adapter.getNewsTypeList().clear();
    adapter.getNewsTypeList().addAll(Arrays.asList(typeItems));
    adapter.notifyDataSetChanged();
  }

  @Override
  public void startNews(int position) {
    NewsActivity.start(baseView.getContext(), position);
  }
}
