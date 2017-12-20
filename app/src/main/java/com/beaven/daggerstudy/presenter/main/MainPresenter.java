package com.beaven.daggerstudy.presenter.main;

import android.support.annotation.NonNull;
import android.view.View;
import com.beaven.daggerstudy.base.BasePresenter;
import com.beaven.daggerstudy.base.BaseRecyclerAdapter;
import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.common.IPageControl;
import com.beaven.daggerstudy.view.NewsActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
  private IPageControl pageControl;

  @Inject
  public MainPresenter(@NonNull MainContract.View baseView, NewsTypeAdapter adapter,
      IPageControl pageControl) {
    super(baseView);
    this.adapter = adapter;
    this.pageControl = pageControl;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    baseView.setAdapter(adapter);
    adapter.setList(getTypeList());
    adapter.setItemClickListener((view, position) -> NewsActivity.start(getContext(), position));
  }

  @Override
  public void startNews(int position) {
    NewsActivity.start(baseView.getContext(), position);
  }

  @Override
  public void updateNews() {
    System.out.println("获取到的pageIndex:" + pageControl.getNextPageIndex());
    adapter.autoUpdateList(getTypeList());
    //pageControl.updateError();
  }

  private List<NewsType> getTypeList() {
    List<NewsType> typeList = new ArrayList<>();
    for (String ss : typeItems) {
      NewsType newsType = new NewsType();
      newsType.setType(ss);
      typeList.add(newsType);
    }
    return typeList;
  }
}
