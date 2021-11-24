package com.graps.remindme.ui.base

import androidx.recyclerview.widget.DiffUtil

class ReminderDiffutils<T>(
    private val remindersList: List<T>,
    private val remindersNewList: List<T>
) :
    DiffUtil.Callback() {
    override fun getOldListSize() = remindersList.size

    override fun getNewListSize() = remindersNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        remindersList[oldItemPosition] == remindersNewList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}