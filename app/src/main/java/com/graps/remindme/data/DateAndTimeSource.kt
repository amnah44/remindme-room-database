package com.graps.remindme.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateAndTimeSource {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalDate() = LocalDate.now()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalCalendar(): Calendar {
        val localDate = getLocalDate()
        val formatterTime = SimpleDateFormat("dd-MM-yyyy").parse(localDate.toString())
        val calendar = Calendar.getInstance()
        calendar.time = formatterTime
        return(calendar)
    }

}