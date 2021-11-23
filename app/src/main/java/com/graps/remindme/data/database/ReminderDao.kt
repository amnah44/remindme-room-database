package com.graps.remindme.data.database

import androidx.room.*
import com.graps.remindme.data.Reminder

@Dao
interface ReminderDao {
    @Insert
    fun insertReminder(reminder:Reminder)

    @Update
    fun updateReminder(reminder:Reminder)

    @Delete
    fun deleteReminder(reminder:Reminder)

    @Query("SELECT * FROM Reminder_table")
    fun getAllReminder():List<Reminder>
}