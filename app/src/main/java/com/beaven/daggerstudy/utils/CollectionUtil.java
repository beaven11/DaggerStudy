package com.beaven.daggerstudy.utils;

import java.util.List;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public class CollectionUtil {

  public static boolean isNullOrEmpty(List<?> list) {
    return list == null || list.isEmpty();
  }
}
