package com.graps.remindme.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    private val repository = ReminderRepository()

    val data = MutableLiveData<List<Reminder>>()

    fun getRemindersDependingOnDate(year: Int, month: Int, day: Int) {
        observe(
            repository.retrieveRemindersDependingOnDate(
                year.toString(),
                month.toString(),
                day.toString()
            ),
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(reminderList: List<Reminder>) {
        data.postValue(reminderList)
    }

    private fun onError(t: Throwable) {
        Log.v("ERROR", t.message.toString())
    }
}