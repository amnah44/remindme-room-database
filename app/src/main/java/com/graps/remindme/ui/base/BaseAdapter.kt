package com.graps.remindme.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    private var items: List<T>,
    private val listener: BaseInteractionListener
) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    abstract val layoutId: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                //holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    override fun getItemCount() = items.size

    fun getItems() = items

    fun setItems(newItems: List<T>) {
        val reminderDiffutils = DiffUtil.calculateDiff(ReminderDiffutils(items, newItems))
        items = newItems
        reminderDiffutils.dispatchUpdatesTo(this)
    }

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    interface BaseInteractionListener
}

