package com.graps.remindme.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel() {
    val repository = ReminderRepository()

    val data = MutableLiveData<List<Reminder>>()


    fun getFilteredData(year: Int, month: Int, day: Int) {
        observe(repository.retrieveRemindersDependingOnDate(
            year.toString(),
            month.toString(),
            day.toString()
        ),
            ::onSuccess,
            ::onError

        )
    }
    fun onSuccess(reminderList: List<Reminder>){
        data.postValue(reminderList)
    }

    fun onError(t: Throwable){
        Log.v("ERROR", t.message.toString())
    }

}