package com.beaven.daggerstudy.model.bean;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * @author : Beaven
 * @time : 2017/12/9 14:07
 */

public class NewsData {
    @SerializedName("uniquekey")
    private String uniqueKey;
    private String title;
    private Date date;
    private String category;
    @SerializedName("author_name")
    private String authorName;
    private String url;
    @SerializedName("thumbnail_pic_s")
    private String picOne;
    @SerializedName("thumbnail_pic_s02")
    private String picTwo;
    @SerializedName("thumbnail_pic_s03")
    private String picThree;

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicOne() {
        return picOne;
    }

    public void setPicOne(String picOne) {
        this.picOne = picOne;
    }

    public String getPicTwo() {
        return picTwo;
    }

    public void setPicTwo(String picTwo) {
        this.picTwo = picTwo;
    }

    public String getPicThree() {
        return picThree;
    }

    public void setPicThree(String picThree) {
        this.picThree = picThree;
    }
}
