package com.beaven.daggerstudy.model.net.api;

import com.beaven.daggerstudy.model.bean.ApiResponse;
import com.beaven.daggerstudy.model.bean.NewsResult;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:17
 */

public interface ApiService {

  @GET("toutiao/index")
  Flowable<ApiResponse<NewsResult>> getNews(@Query("type") String type);
}
