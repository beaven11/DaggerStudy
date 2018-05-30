package com.beaven.daggerstudy.base.contract;

import android.support.v7.widget.RecyclerView;
import com.beaven.daggerstudy.base.BaseContract;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:29
 */

public interface NewsContract {

    interface View extends BaseContract.View {

        void setAdapter(RecyclerView.Adapter adapter);
    }

    interface Presenter extends BaseContract.Presenter {

        void loadNews();
    }
}
