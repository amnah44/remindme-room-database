package com.graps.remindme.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    val repository = ReminderRepository()

    val data = MutableLiveData<List<Reminder>>()

    fun getDate(year: Int, month: Int, day: Int) {
        data.postValue(
            repository.retrieveRemindersDependingOnDate(
                year.toString(),
                month.toString(),
                day.toString()
            )
        )
    }


}