package com.beaven.daggerstudy.app;

import android.app.Application;
import com.beaven.daggerstudy.di.component.AppComponent;
import com.beaven.daggerstudy.di.component.DaggerAppComponent;
import com.beaven.daggerstudy.di.module.AppModule;
import com.beaven.daggerstudy.di.module.NetModule;

/**
 * @author : Beaven
 * @time : 2017/12/9 13:47
 */
public class BaseApp extends Application {

  private static BaseApp instance;
  private static AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
  }

  public static BaseApp getApplication() {
    return instance;
  }

  public static AppComponent getAppComponent() {
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder()
          .appModule(new AppModule(instance))
          .netModule(new NetModule())
          .build();
    }
    return appComponent;
  }
}
