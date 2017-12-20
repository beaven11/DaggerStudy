package com.beaven.daggerstudy.presenter.main;

import com.beaven.daggerstudy.base.AdapterItem;

/**
 * @author : Beaven
 * @date : 2017-12-19
 */

public class NewsType implements AdapterItem {

  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public int getAdapterItemType() {
    return 0;
  }
}
