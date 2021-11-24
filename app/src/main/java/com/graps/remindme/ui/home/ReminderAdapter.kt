package com.graps.remindme.ui.home

import com.graps.remindme.R
import com.graps.remindme.data.Reminder
import com.graps.remindme.ui.base.BaseAdapter

class ReminderAdapter(
    items: List<Reminder>,
    listener: ReminderInteractionListener,
) : BaseAdapter<Reminder>(items, listener) {
    override val layoutId: Int = R.layout.item_drug
}

interface ReminderInteractionListener : BaseAdapter.BaseInteractionListener