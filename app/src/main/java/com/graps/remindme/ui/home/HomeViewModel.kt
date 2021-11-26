package com.graps.remindme.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    val repository = ReminderRepository()

    val data = MutableLiveData<List<Reminder>>()

//    private val _reminders = MutableLiveData<Reminder>()
//    val reminders: LiveData<Reminder>
//            get()= _reminders

    fun getDate(year: Int, month: Int, day: Int) {
        data.postValue(
            repository.retrieveRemindersDependingOnDate(
                year.toString(),
                month.toString(),
                day.toString()
            )
        )
       Log.i("Amnah", "Y:$year M:$month D:$day")
    }

}