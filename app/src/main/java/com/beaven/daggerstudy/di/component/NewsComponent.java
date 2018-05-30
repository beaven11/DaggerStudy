package com.beaven.daggerstudy.di.component;

import com.beaven.daggerstudy.di.module.NewsModule;
import com.beaven.daggerstudy.di.scope.ActivityScope;
import com.beaven.daggerstudy.view.NewsActivity;
import dagger.Component;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:46
 */
@ActivityScope
@Component(modules = NewsModule.class, dependencies = AppComponent.class)
public interface NewsComponent {

    void inject(NewsActivity activity);
}
