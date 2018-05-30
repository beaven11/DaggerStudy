package com.beaven.daggerstudy.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author : Beaven
 * @date : 2017-12-19
 */

public abstract class BaseHeadFooterAdapter<T, VH extends BaseViewHolder<T>>
        extends BaseRecyclerAdapter<T, VH> {

    public static final int ADAPTER_TYPE_HEADER = 0x01;
    public static final int ADAPTER_TYPE_FOOTER = 0x02;

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ADAPTER_TYPE_HEADER) {
            return onCreateHeaderViewHolder(parent, viewType);
        } else if (viewType == ADAPTER_TYPE_FOOTER) {
            return onCreateFooterViewHolder(parent, viewType);
        }
        return onCreateItemViewHolder(parent, viewType);
    }

    protected VH onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    protected VH onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    protected abstract VH onCreateItemViewHolder(ViewGroup parent, int viewType);

    public void setHeader(View view) {

    }

    public void setFooter(View view) {

    }
}
