package com.beaven.daggerstudy.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.beaven.daggerstudy.app.AppConfig;
import com.beaven.daggerstudy.common.IPageControl;
import com.beaven.daggerstudy.utils.CollectionUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public class RefreshLayoutWrapper extends SmartRefreshLayout implements IPageControl {

    private static final String TAG = "RefreshLayoutWrapper";
    /**
     * 预显示界面索引
     */
    private static final int NONE_PRE_PAGE_INDEX = -1;
    /**
     * 未刷新状态
     */
    public static final int REFRESH_NORMAL = 0;
    /**
     * 正在加载状态
     */
    public static final int REFRESH_LOADING = 1;
    /**
     * 正在刷新状态
     */
    public static final int REFRESH_REFRESHING = 2;

    /**
     * 当前页面index
     */
    private int currentPageIndex;

    /**
     * 预加载页的index
     */
    private int prePageIndex;

    /**
     * 一页的条目，默认16
     */
    private int pageSize = AppConfig.LIST_PAGE_SIZE;

    public RefreshLayoutWrapper(Context context) {
        this(context, null);
    }

    public RefreshLayoutWrapper(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshLayoutWrapper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        currentPageIndex = 1;
        prePageIndex = NONE_PRE_PAGE_INDEX;
        setDisableContentWhenLoading(true);
        setDisableContentWhenRefresh(true);
    }

    /**
     * 列表更新成功
     *
     * @param list 更新数据集合
     */
    @Override
    public void updateSuccess(List<?> list) {
        if (isRefreshing()) {
            setLoadmoreFinished(false);
        } else if (isLoading()) {
            if (CollectionUtil.isNullOrEmpty(list) || list.size() < pageSize) {
                setLoadmoreFinished(true);
            }
        }
        updateCurrentPageIndex();
        finishUpdate(true);
    }

    /**
     * 列表更新失败
     */
    @Override
    public void updateError() {
        this.prePageIndex = -1;
        finishUpdate(false);
    }

    @Override
    public void resetPageIndex() {
        this.prePageIndex = 1;
    }

    @Override
    public void loadNextPageIndex() {
        this.prePageIndex = this.currentPageIndex + 1;
    }

    @Override
    public int getNextPageIndex() {
        return this.prePageIndex;
    }

    @Override
    public int getRefreshStates() {
        if (isRefreshing()) {
            return REFRESH_REFRESHING;
        } else if (isLoading()) {
            return REFRESH_LOADING;
        }
        return REFRESH_NORMAL;
    }

    /**
     * 结束刷新或加载状态
     *
     * @param success 状态成功或失败
     */
    private void finishUpdate(boolean success) {
        if (isRefreshing()) {
            finishRefresh(success);
        } else if (isLoading()) {
            finishLoadmore(success);
        }
    }

    /**
     * 当前页面索引更新
     */
    private void updateCurrentPageIndex() {
        this.currentPageIndex = this.prePageIndex;
        this.prePageIndex = NONE_PRE_PAGE_INDEX;
    }
}
