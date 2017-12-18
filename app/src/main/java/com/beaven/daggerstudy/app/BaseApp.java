package com.beaven.daggerstudy.app;

import android.app.Application;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.di.component.AppComponent;
import com.beaven.daggerstudy.di.component.DaggerAppComponent;
import com.beaven.daggerstudy.di.module.AppModule;
import com.beaven.daggerstudy.di.module.NetModule;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

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

  //static 代码段可以防止内存泄露
  static {
    //设置全局的Header构建器
    SmartRefreshLayout.setDefaultRefreshHeaderCreater((context, layout) -> {
      layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
      return new ClassicsHeader(
          context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
    });
    //设置全局的Footer构建器
    SmartRefreshLayout.setDefaultRefreshFooterCreater((context, layout) -> {
      //指定为经典Footer，默认是 BallPulseFooter
      return new ClassicsFooter(context).setDrawableSize(20);
    });
  }
}
