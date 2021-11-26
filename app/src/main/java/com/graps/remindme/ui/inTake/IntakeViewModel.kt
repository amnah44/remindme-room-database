package com.graps.remindme.ui.inTake

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.android.material.internal.ContextUtils.getActivity
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import kotlin.coroutines.coroutineContext

class IntakeViewModel: BaseViewModel() {

    val  pillsName = MutableLiveData<String>()
    val  amount = MutableLiveData<Int>()

    val  dose = MutableLiveData<String>()
    val  year = MutableLiveData<String>()
    val  month = MutableLiveData<String>()
    val  day = MutableLiveData<String>()
    val  frequency = MutableLiveData<String>()
    val  phoneNo = MutableLiveData<String>()
    val  image = MutableLiveData<String>()

    private val  repository = ReminderRepository()

    init {
        amount.value=1
    }
    fun addReminder()
    {
        pillsName.value.let {
            repository.insertReminder(Reminder(id = null,
                name = it,
                amount.value,
                dose.value,
                year = year.value,
                month.value,
                day = day.value,
                frequency.value,
                "1",
                phoneNo.value)
            )
                ?.subscribeOn(io())
                ?.subscribe(::onSuccess,::onError)
        }
    }

    private fun onSuccess() = amount.postValue(1)

    private fun onError(e:Throwable){
      println(e.message)
    }

}