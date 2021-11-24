package com.graps.remindme.data.database

import androidx.room.*
import com.graps.remindme.data.Reminder
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface ReminderDao {
    @Insert
    fun insertReminder(reminder:Reminder):Completable

    @Update
    fun updateReminder(reminder:Reminder):Completable

    @Delete
    fun deleteReminder(reminder:Reminder):Completable

    @Query("SELECT * FROM Reminder_table")
    fun getAllReminder():Observable<List<Reminder>>

    @Query("SELECT * FROM Reminder_table WHERE Year = :year and Month = :month and Day = :day")
    fun getFilteredReminders(
        year :String,
        month:String,
        day:String,
    )
}