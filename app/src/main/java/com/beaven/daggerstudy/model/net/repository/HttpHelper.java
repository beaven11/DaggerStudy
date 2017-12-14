package com.beaven.daggerstudy.model.net.repository;

import com.beaven.daggerstudy.model.bean.NewsResult;
import io.reactivex.Flowable;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:30
 */

public interface HttpHelper {
  Flowable<NewsResult> getNews(String type);
}
