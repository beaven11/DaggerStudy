package com.beaven.daggerstudy.base;

import android.content.Context;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:26
 */

public interface BaseContract {

    interface View {

        void showToast(String msg);

        void showContentEmpty();

        void showContentError();

        void showLoading(String msg);

        void showContent();

        Context getContext();
    }

    interface Presenter {

        void onCreate();

        void onResume();

        void onPause();

        void onDestroy();

        Context getContext();
    }
}
