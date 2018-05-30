package com.beaven.daggerstudy.model.bean;

import java.util.List;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:08
 */

public class NewsResult {

    private String stat;
    private List<NewsData> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsData> getNewsDataList() {
        return data;
    }

    public void setNewsDataList(List<NewsData> data) {
        this.data = data;
    }
}
