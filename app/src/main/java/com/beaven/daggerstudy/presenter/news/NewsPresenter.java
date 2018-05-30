package com.beaven.daggerstudy.presenter.news;

import android.support.annotation.NonNull;
import com.beaven.daggerstudy.base.BasePresenter;
import com.beaven.daggerstudy.base.contract.NewsContract;
import com.beaven.daggerstudy.model.DataManager;
import com.beaven.daggerstudy.model.bean.NewsData;
import com.beaven.daggerstudy.model.bean.NewsResult;
import com.beaven.daggerstudy.model.net.codes.ApiSubscriber;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:30
 */

public class NewsPresenter extends BasePresenter<NewsContract.View>
        implements NewsContract.Presenter {

    public static final String NEWS_TYPE_NAME = "news_type";

    private NewsResultAdapter adapter;
    private DataManager dataManager;
    private String type;

    @Inject
    public NewsPresenter(@NonNull NewsContract.View baseView, NewsResultAdapter adapter,
            @Named(NEWS_TYPE_NAME) String type, DataManager dataManager) {
        super(baseView);
        this.adapter = adapter;
        this.type = type;
        this.dataManager = dataManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseView.setAdapter(adapter);
        loadNews();
    }

    @Override
    public void loadNews() {
        disposable.add(dataManager.getNews(type)
                .doOnSubscribe(subscription -> {
                    System.out.println("doOnSubscribe");
                })
                .doFinally(() -> System.out.println("doFinally"))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .subscribeWith(new ApiSubscriber<NewsResult>(baseView) {
                    @Override
                    protected void onStart() {
                        super.onStart();
                        System.out.println("OnStart");
                    }

                    @Override
                    public void onNext(NewsResult newsResult) {
                        super.onNext(newsResult);
                        System.out.println("onNext");
                        List<NewsData> dataList = newsResult.getNewsDataList();
                        if (dataList == null || dataList.isEmpty()) {
                            return;
                        }
                        adapter.getDataList().clear();
                        adapter.getDataList().addAll(dataList);
                        adapter.notifyDataSetChanged();
                    }
                }));
    }
}
