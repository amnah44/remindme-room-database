package com.graps.remindme.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.graps.remindme.data.Reminder

@Dao
interface ReminderDao {

    @Insert
    fun insertReminder(reminder:Reminder)
}