package com.beaven.daggerstudy.di.component;

import com.beaven.daggerstudy.di.module.MainModule;
import com.beaven.daggerstudy.di.scope.ActivityScope;
import com.beaven.daggerstudy.view.MainActivity;
import dagger.Component;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:58
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
