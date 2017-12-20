package com.beaven.daggerstudy.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.beaven.daggerstudy.common.IAdapterListControl;
import com.beaven.daggerstudy.common.IPageControl;
import com.beaven.daggerstudy.utils.CollectionUtil;
import com.beaven.daggerstudy.widget.RefreshLayoutWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public abstract class BaseRecyclerAdapter<T, VH extends BaseViewHolder<T>>
        extends RecyclerView.Adapter<VH> implements IAdapterListControl<T> {

    public interface OnItemClickListener {
        void itemClick(View view, int position);
    }

    private List<T> adapterList;
    private IPageControl pageControl;
    private OnItemClickListener itemClickListener;

    public BaseRecyclerAdapter() {
        this(null);
    }

    public BaseRecyclerAdapter(IPageControl pageControl) {
        this.adapterList = new ArrayList<>();
        this.pageControl = pageControl;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        holder.itemView.setOnClickListener(view -> {
            if (itemClickListener != null) {
                itemClickListener.itemClick(view, position);
            }
        });
        holder.bindData(getListItem(position), position);
    }

    @Override
    public int getItemCount() {
        return adapterList == null ? 0 : adapterList.size();
    }

    @Override
    public void setList(List<T> list) {
        adapterList.clear();
        adapterList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void addList(List<T> list) {
        adapterList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 自动更新列表集合，根据当前刷新状态判断进行刷新或加载操作
     *
     * @param list 更新数据集合
     */
    @Override
    public void autoUpdateList(List<T> list) {
        if (pageControl == null) {
            throw new IllegalStateException("pageControl must be set");
        }
        pageControl.updateSuccess(list);
        if (CollectionUtil.isNullOrEmpty(list)) {
            return;
        }
        int states = pageControl.getRefreshStates();
        if (states == RefreshLayoutWrapper.REFRESH_LOADING) {
            addList(list);
        } else if (states == RefreshLayoutWrapper.REFRESH_REFRESHING) {
            setList(list);
        }
    }

    @Override
    public T getListItem(int index) {
        if (index < 0 || index > adapterList.size() - 1) {
            return null;
        }
        return adapterList.get(index);
    }
}
