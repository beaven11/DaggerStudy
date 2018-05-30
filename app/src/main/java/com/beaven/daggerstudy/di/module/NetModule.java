package com.beaven.daggerstudy.di.module;

import android.util.Log;
import com.beaven.daggerstudy.app.AppConfig;
import com.beaven.daggerstudy.model.net.api.ApiService;
import com.beaven.daggerstudy.model.net.codes.KeyInterceptor;
import com.beaven.daggerstudy.utils.JsonUtil;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : Beaven
 * @time : 2017/12/9 13:51
 */
@Module
public class NetModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return JsonUtil.gson;
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor provideHttpInterceptor() {
        HttpLoggingInterceptor.Logger logger = message -> Log.d(AppConfig.NET_TAG, message);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);
        loggingInterceptor.setLevel(AppConfig.IS_DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttp(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder builder =
                new OkHttpClient.Builder().readTimeout(AppConfig.HTTP_TIMEOUT, TimeUnit.MINUTES)
                        .connectTimeout(AppConfig.HTTP_TIMEOUT, TimeUnit.MINUTES)
                        .addInterceptor(new KeyInterceptor())
                        .addInterceptor(interceptor);
        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(AppConfig.URL_BASE)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
        return builder.build();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
