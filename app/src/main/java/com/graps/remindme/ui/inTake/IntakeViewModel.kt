package com.graps.remindme.ui.inTake

import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseViewModel
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io

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
        amount.postValue(1)
    }
    fun addReminder()
    {
        pillsName.value.let {
            repository.insertReminder(Reminder(id = 0, name = it,amount.value,dose.value,year = year.value, month.value, day = day.value,frequency.value,"1",phoneNo.value))
                ?.subscribeOn(io())
                ?.subscribe()
        }
    }
}