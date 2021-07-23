package com.workindia.ui.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {
    @SerializedName("items")
    @Expose
    private List<ItemDetail> items;

    public List<ItemDetail> getitems() {
        return items;
    }

    public void setitems(List<ItemDetail> cases_time_series) {
        this.items = cases_time_series;
    }
}

