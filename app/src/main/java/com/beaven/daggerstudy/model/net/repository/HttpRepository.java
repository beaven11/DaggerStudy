package com.beaven.daggerstudy.model.net.repository;

import com.beaven.daggerstudy.model.bean.NewsResult;
import com.beaven.daggerstudy.model.net.api.ApiService;
import com.beaven.daggerstudy.utils.RxUtil;
import io.reactivex.Flowable;
import javax.inject.Inject;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:31
 */

public class HttpRepository implements HttpHelper {

    private final ApiService apiService;

    @Inject
    public HttpRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Flowable<NewsResult> getNews(String type) {
        return RxUtil.create(apiService.getNews(type));
    }
}
