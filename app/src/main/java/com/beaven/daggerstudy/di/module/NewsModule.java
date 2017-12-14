package com.beaven.daggerstudy.di.module;

import com.beaven.daggerstudy.base.contract.NewsContract;
import com.beaven.daggerstudy.di.scope.ActivityScope;
import com.beaven.daggerstudy.presenter.news.NewsPresenter;
import com.beaven.daggerstudy.presenter.news.NewsResultAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import javax.inject.Named;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:45
 */
@ActivityScope
@Module(includes = NewsModule.Presenter.class)
public class NewsModule {

  @Module
  public interface Presenter {
    @Binds
    NewsContract.Presenter bindPresnter(NewsPresenter mainPresenter);
  }

  private NewsContract.View view;
  private String type;

  public NewsModule(NewsContract.View view, String type) {
    this.view = view;
    this.type = type;
  }

  @Provides
  public NewsContract.View provideNewsView() {
    return view;
  }

  @Named(NewsPresenter.NEWS_TYPE_NAME)
  @Provides
  public String provideType() {
    return type;
  }

  @Provides
  public NewsResultAdapter provideNewsResultAdapter() {
    return new NewsResultAdapter(new ArrayList<>());
  }
}
