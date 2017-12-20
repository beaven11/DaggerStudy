package com.beaven.daggerstudy.presenter.main;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.base.BaseRecyclerAdapter;
import com.beaven.daggerstudy.base.BaseViewHolder;
import com.beaven.daggerstudy.base.contract.MainContract;
import com.beaven.daggerstudy.common.IPageControl;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:12
 */

public class NewsTypeAdapter extends BaseRecyclerAdapter<NewsType, NewsTypeAdapter.NewsTypeHolder> {

  public NewsTypeAdapter(IPageControl pageControl) {
    super(pageControl);
  }

  @Override
  public NewsTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new NewsTypeHolder(R.layout.item_news_type, parent);
  }

  static class NewsTypeHolder extends BaseViewHolder<NewsType> {

    @BindView(R.id.text_news_type_item)
    TextView textItem;

    public NewsTypeHolder(int layoutId, ViewGroup parent) {
      super(layoutId, parent);
    }

    @Override
    public void bindData(NewsType data, int position) {
      if (TextUtils.isEmpty(data.getType())) {
        return;
      }
      textItem.setText(data.getType());
    }
  }
}
