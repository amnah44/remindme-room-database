package com.graps.remindme.ui.inTake


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.ui.base.BaseAdapter
import com.graps.remindme.ui.base.BaseViewModel
import com.graps.remindme.util.Appearance
import com.graps.remindme.util.AppearanceList
import io.reactivex.rxjava3.schedulers.Schedulers.io


class IntakeViewModel: BaseViewModel(),BaseAdapter.BaseInteractionListener {

    val appearanceList =AppearanceList()

    val  pillsName = MutableLiveData<String>()
    val  amount = MutableLiveData<Int>()

    val  dose = MutableLiveData<String>()
    val  year = MutableLiveData<String>()
    val  month = MutableLiveData<String>()
    val  day = MutableLiveData<String>()
    val  frequency = MutableLiveData<String>()
    val  phoneNo = MutableLiveData<String>()
    //val  image = MutableLiveData<String>()

    private val  repository = ReminderRepository()

    init {
        amount.value=1
        dose.value = "mg"
    }
    fun addReminder()
    {
        pillsName.value.let {
            repository.insertReminder(Reminder(id = null,
                name = it,
                amount.value,
                dose.value+"mg",
                year = year.value,
                month.value,
                day = day.value,
                frequency.value,
                appearnceSomething().toString(),
                phoneNo.value)
            ).subscribeOn(io()).subscribe(::onSuccess,::onError)
            amount.postValue(1)
            dose.postValue("")
            year.postValue("")
            frequency.postValue("")
            phoneNo.postValue("")
            pillsName.postValue("")
        }
    }

    private fun onSuccess() = amount.postValue(1)

    private fun onError(e:Throwable){
      println(e.message)
    }

    fun appearnceSomething(): Int {
        val list =AppearanceList().appearanceList
        println(list[0])
        return list[0].image
    }
}