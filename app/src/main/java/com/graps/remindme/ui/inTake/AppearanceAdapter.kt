package com.graps.remindme.ui.inTake

import com.graps.remindme.R
import com.graps.remindme.ui.base.BaseAdapter
import com.graps.remindme.util.Appearance

class AppearanceAdapter(
    item: List<Appearance>,
    listener: BaseInteractionListener
):
    BaseAdapter<Appearance>(item,listener) {
    override val layoutId: Int
        get() = R.layout.item_appearance
}