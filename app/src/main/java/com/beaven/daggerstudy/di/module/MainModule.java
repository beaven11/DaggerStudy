package com.beaven.daggerstudy.di.module;

import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.di.scope.ActivityScope;
import com.beaven.daggerstudy.presenter.main.MainPresenter;
import com.beaven.daggerstudy.presenter.main.NewsTypeAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:57
 */
@ActivityScope
@Module(includes = MainModule.Presenter.class)
public class MainModule {

  @Module
  public interface Presenter {
    @Binds
    MainContract.Presenter bindPresnter(MainPresenter mainPresenter);
  }

  private final MainContract.View view;

  public MainModule(MainContract.View view) {
    this.view = view;
  }

  @Provides
  public MainContract.View provideMainView() {
    return view;
  }

  @Provides
  public NewsTypeAdapter provideAdapter(MainContract.View view) {
    return new NewsTypeAdapter(view, new ArrayList<>());
  }
}
