package com.fitsttest.smartbreeder_fitst;

import com.fitsttest.smartbreeder_fitst.Item;

import java.util.List;

public interface OnFinishSearchListener {
    public void onSuccess(List<Item> itemList);

    public void onFail();
}
