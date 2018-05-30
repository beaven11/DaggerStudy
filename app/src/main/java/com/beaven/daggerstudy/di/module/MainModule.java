package com.beaven.daggerstudy.di.module;

import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.common.IPageControl;
import com.beaven.daggerstudy.di.scope.ActivityScope;
import com.beaven.daggerstudy.presenter.main.MainPresenter;
import com.beaven.daggerstudy.presenter.main.NewsTypeAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:57
 */
@Module(includes = MainModule.Presenter.class)
public class MainModule {

    @Module
    public interface Presenter {
        @Binds
        MainContract.Presenter bindPresnter(MainPresenter mainPresenter);
    }

    private final MainContract.View view;
    private final IPageControl pageControl;

    public MainModule(MainContract.View view, IPageControl pageControl) {
        this.view = view;
        this.pageControl = pageControl;
    }

    @ActivityScope
    @Provides
    public MainContract.View provideMainView() {
        return view;
    }

    @ActivityScope
    @Provides
    public IPageControl providePageControl() {
        return pageControl;
    }

    @ActivityScope
    @Provides
    public NewsTypeAdapter provideAdapter(IPageControl pageControl) {
        return new NewsTypeAdapter(pageControl);
    }
}
