package com.beaven.daggerstudy.model;

import com.beaven.daggerstudy.model.bean.NewsResult;
import com.beaven.daggerstudy.model.net.repository.HttpHelper;
import io.reactivex.Flowable;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:05
 */

public class DataManager implements HttpHelper {

  private final HttpHelper httpHelper;

  public DataManager(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  @Override
  public Flowable<NewsResult> getNews(String type) {
    return httpHelper.getNews(type);
  }
}
