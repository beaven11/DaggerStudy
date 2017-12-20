package com.beaven.daggerstudy.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  public BaseViewHolder(int layoutId, ViewGroup parent) {
    this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
  }

  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public abstract void bindData(T data, int position);
}
