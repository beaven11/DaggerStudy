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

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder
    implements View.OnClickListener {

  private OnItemClickListener itemClickListener;

  public BaseViewHolder(int layoutId, ViewGroup parent) {
    this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
  }

  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    itemView.setOnClickListener(this);
  }

  public abstract void showItem(T data, int position);

  public void setItemClickListener(OnItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  @Override
  public void onClick(View view) {
    if (itemClickListener != null) {
      itemClickListener.clickItem(view, this.getAdapterPosition());
    }
  }

  public interface OnItemClickListener {
    void clickItem(View view, int position);
  }
}
