package com.beaven.daggerstudy.common;

import java.util.List;

/**
 * @author : Beaven
 * @date : 2017-12-18
 */

public interface IAdapterListControl<T> {

    void setList(List<T> list);

    void addList(List<T> list);

    void autoUpdateList(List<T> list);

    T getListItem(int index);
}
