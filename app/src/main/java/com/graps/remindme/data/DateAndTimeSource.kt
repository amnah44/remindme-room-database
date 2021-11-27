package com.graps.remindme.data

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class DateAndTimeSource {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalDate(): LocalDate = LocalDate.now()

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalCalendar(): Calendar {
        val localDate = getLocalDate()
        val formatterTime = SimpleDateFormat("dd-MM-yyyy").parse(localDate.toString())
        val calendar = Calendar.getInstance()
        calendar.time = formatterTime
        return(calendar)
    }

}