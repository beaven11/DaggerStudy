package com.beaven.daggerstudy.utils;

import com.beaven.daggerstudy.model.bean.ApiResponse;
import com.beaven.daggerstudy.model.net.codes.ApiException;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:34
 */

public class RxUtil {

  private RxUtil() {
  }

  public static <T> Flowable<T> createData(final T t) {
    return Flowable.create(emitter -> {
      try {
        emitter.onNext(t);
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    }, BackpressureStrategy.BUFFER);
  }

  /** 统一的线程切换处理 */
  public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {
    return upstream -> upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  /**
   * 转换请求结果，统一进行错误处理
   *
   * @return 结果
   */
  public static <T> FlowableTransformer<ApiResponse<T>, T> transformerResult() {
    return httpResponseFollowable -> httpResponseFollowable.flatMap(
        (Function<ApiResponse<T>, Flowable<T>>) apiResponse -> {
          if (apiResponse.isSuccess()) {
            return createData(apiResponse.getResult());
          } else {
            Flowable.error(new ApiException(apiResponse.getCode(), apiResponse.getReason()));
          }
          return Flowable.empty();
        });
  }
}
