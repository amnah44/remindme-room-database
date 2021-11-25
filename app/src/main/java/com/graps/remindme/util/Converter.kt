package com.graps.remindme.util

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    fun longToDate(long: Long):Date = Date(long)
}