package com.beaven.daggerstudy.common;

import com.beaven.daggerstudy.widget.RefreshLayoutWrapper;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public abstract class AbsOnRefreshLoadMoreListener implements OnRefreshLoadmoreListener {

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        RefreshLayoutWrapper refreshLayoutWrapper = (RefreshLayoutWrapper) refreshlayout;
        refreshLayoutWrapper.resetPageIndex();
        update(refreshlayout);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        RefreshLayoutWrapper refreshLayoutWrapper = (RefreshLayoutWrapper) refreshlayout;
        refreshLayoutWrapper.loadNextPageIndex();
        update(refreshlayout);
    }

    public abstract void update(RefreshLayout refreshLayout);
}