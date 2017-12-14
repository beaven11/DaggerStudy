package com.beaven.daggerstudy.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author : Beaven
 * @time : 2017/12/9 13:52
 */

public class JsonUtil {

  public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

  public static final Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
}
