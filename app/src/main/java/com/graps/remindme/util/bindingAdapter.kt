package com.graps.remindme.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import com.graps.remindme.ui.base.BaseAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items:List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}
    @BindingAdapter(value = ["app:setImage"])
    fun setImage(view:ImageView, item:Int?){
        if (item != null) {
            view.setBackgroundResource(item)
        }
    }



