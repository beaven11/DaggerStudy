package com.beaven.daggerstudy.base.contract;

import android.support.v7.widget.RecyclerView;
import com.beaven.daggerstudy.base.BaseContract;

/**
 * @author : Beaven
 * @time : 2017/12/9 15:55
 */

public interface MainContract {

    interface View extends BaseContract.View {

        void setAdapter(RecyclerView.Adapter adapter);

        void startNews(int position);
    }

    interface Presenter extends BaseContract.Presenter {

        void startNews(int position);

        void updateNews();
    }
}
