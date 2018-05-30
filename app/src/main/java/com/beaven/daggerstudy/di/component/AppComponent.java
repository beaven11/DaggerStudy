package com.beaven.daggerstudy.di.component;

import android.app.Application;
import com.beaven.daggerstudy.di.module.AppModule;
import com.beaven.daggerstudy.di.module.NetModule;
import com.beaven.daggerstudy.model.DataManager;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:45
 */
@Singleton
@Component(modules = { AppModule.class, NetModule.class })
public interface AppComponent {

    Application getApplicationContext();

    DataManager getDataManager();
}
