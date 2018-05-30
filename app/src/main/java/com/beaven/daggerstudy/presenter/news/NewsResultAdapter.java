package com.beaven.daggerstudy.presenter.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.model.bean.NewsData;
import com.beaven.daggerstudy.utils.ImageUtil;
import java.util.List;

/**
 * @author : Beaven
 * @time : 2017/12/9 17:00
 */

public class NewsResultAdapter extends RecyclerView.Adapter<NewsResultAdapter.NewsResultHolder> {

    private List<NewsData> dataList;

    public NewsResultAdapter(List<NewsData> dataList) {
        this.dataList = dataList;
    }

    public List<NewsData> getDataList() {
        return dataList;
    }

    @Override
    public NewsResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_result, parent, false);
        return new NewsResultHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsResultHolder holder, int position) {
        NewsData newsData = dataList.get(position);
        if (newsData == null) {
            return;
        }
        holder.textNewsResult.setText(newsData.getTitle());
        ImageUtil.load(newsData.getPicOne(), holder.imageNewsResult);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static class NewsResultHolder extends RecyclerView.ViewHolder {

        ImageView imageNewsResult;
        TextView textNewsResult;

        public NewsResultHolder(View itemView) {
            super(itemView);
            imageNewsResult = itemView.findViewById(R.id.image_news_result_item);
            textNewsResult = itemView.findViewById(R.id.text_news_result_item);
        }
    }
}
