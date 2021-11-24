package com.graps.remindme.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.graps.remindme.ui.base.BaseAdapter


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items:List<T>?) {

    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItem(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
    }

}


