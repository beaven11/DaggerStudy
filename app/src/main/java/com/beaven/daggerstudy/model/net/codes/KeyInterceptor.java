package com.beaven.daggerstudy.model.net.codes;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : Beaven
 * @time : 2017/12/9 17:49
 */

public class KeyInterceptor implements Interceptor {

  private static final String KEY = "491acd7125821184b963e3bc2e490e62";

  private static final String KEY_PARAM = "key";

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {
    Request request = chain.request();
    HttpUrl httpUrl = request.url().newBuilder().addQueryParameter(KEY_PARAM, KEY).build();
    request = request.newBuilder().url(httpUrl).build();
    return chain.proceed(request);
  }
}
