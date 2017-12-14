package com.beaven.daggerstudy.presenter.main;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.base.contract.MainContract;
import java.util.List;

/**
 * @author : Beaven
 * @time : 2017/12/9 16:12
 */

public class NewsTypeAdapter extends RecyclerView.Adapter<NewsTypeAdapter.NewsTypeHolder> {

  private List<String> newsTypeList;
  private MainContract.View mainView;

  public NewsTypeAdapter(MainContract.View mainView, List<String> newsTypeList) {
    this.mainView = mainView;
    this.newsTypeList = newsTypeList;
  }

  public List<String> getNewsTypeList() {
    return newsTypeList;
  }

  @Override
  public NewsTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_type, parent, false);
    return new NewsTypeHolder(view);
  }

  @Override
  public void onBindViewHolder(NewsTypeHolder holder, int position) {
    String item = newsTypeList.get(position);
    if (TextUtils.isEmpty(item)) {
      return;
    }
    holder.textItem.setText(item);
    holder.textItem.setOnClickListener(view -> mainView.startNews(position));
  }

  @Override
  public int getItemCount() {
    return newsTypeList == null ? 0 : newsTypeList.size();
  }

  static class NewsTypeHolder extends RecyclerView.ViewHolder {

    TextView textItem;

    NewsTypeHolder(View itemView) {
      super(itemView);
      textItem = itemView.findViewById(R.id.text_news_type_item);
    }
  }
}
