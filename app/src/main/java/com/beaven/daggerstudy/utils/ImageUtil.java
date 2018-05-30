package com.beaven.daggerstudy.utils;

import android.widget.ImageView;
import com.beaven.daggerstudy.R;
import com.beaven.daggerstudy.app.GlideApp;

/**
 * @author : Beaven
 * @time : 2017/12/9 17:14
 */

public class ImageUtil {

    public static void load(String url, ImageView imageView) {
        GlideApp.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
