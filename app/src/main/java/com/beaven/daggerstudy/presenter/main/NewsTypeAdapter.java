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
import java.util.List;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:12
 */

public class NewsTypeAdapter extends BaseRecyclerAdapter<String, NewsTypeAdapter.NewsTypeHolder> {

  private MainContract.View mainView;

  public NewsTypeAdapter(MainContract.View mainView, List<String> adapterList,
      IPageControl pageControl) {
    super(adapterList, pageControl);
    this.mainView = mainView;
  }

  @Override
  public NewsTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new NewsTypeHolder(R.layout.item_news_type, parent);
  }

  @Override
  public void onBindViewHolder(NewsTypeHolder holder, int position) {
    String item = getListItem(position);
    holder.showItem(item, position);
    holder.setItemClickListener((view, position1) -> mainView.startNews(position1));
  }

  static class NewsTypeHolder extends BaseViewHolder<String> {

    @BindView(R.id.text_news_type_item)
    TextView textItem;

    public NewsTypeHolder(int layoutId, ViewGroup parent) {
      super(layoutId, parent);
    }

    @Override
    public void showItem(String data, int position) {
      if (TextUtils.isEmpty(data)) {
        return;
      }
      textItem.setText(data);
    }
  }
}
