package com.beaven.daggerstudy.di.module;

import android.app.Application;
import com.beaven.daggerstudy.model.DataManager;
import com.beaven.daggerstudy.model.net.repository.HttpHelper;
import com.beaven.daggerstudy.model.net.repository.HttpRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author : Beaven
 * @time : 2017/12/9 13:49
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    HttpHelper provideHttpHelper(HttpRepository httpRepository) {
        return httpRepository;
    }

    @Singleton
    @Provides
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
