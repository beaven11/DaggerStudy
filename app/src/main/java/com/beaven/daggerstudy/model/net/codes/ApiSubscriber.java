package com.beaven.daggerstudy.model.net.codes;

import android.support.annotation.NonNull;
import android.util.Log;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.app.AppConfig;
import com.beaven.daggerstudy.base.BaseContract;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:23
 */

public abstract class ApiSubscriber<T> extends ResourceSubscriber<T> {

    private static final String TAG = AppConfig.NET_TAG;

    private BaseContract.View baseView;

    protected ApiSubscriber(@NonNull BaseContract.View baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        Log.e(TAG, "onError: ", t);
        if (baseView == null) {
            return;
        }
        if (t instanceof ApiException) {
            baseView.showToast(t.getMessage());
        } else if (t instanceof HttpException) {
            baseView.showToast(
                    baseView.getContext().getResources().getString(R.string.exception_http));
        } else {
            baseView.showToast(
                    baseView.getContext().getResources().getString(R.string.exception_unknown));
        }
    }

    @Override
    public void onComplete() {

    }
}
