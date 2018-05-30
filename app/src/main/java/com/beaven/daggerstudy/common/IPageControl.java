package com.beaven.daggerstudy.common;

import java.util.List;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public interface IPageControl {

    void resetPageIndex();

    void loadNextPageIndex();

    int getNextPageIndex();

    int getRefreshStates();

    void updateSuccess(List<?> list);

    void updateError();
}
