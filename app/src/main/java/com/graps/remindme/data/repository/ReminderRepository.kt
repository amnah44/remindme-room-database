package com.graps.remindme.data.repository

import com.graps.remindme.data.Reminder
import com.graps.remindme.data.database.ReminderDatabase
import io.reactivex.rxjava3.core.Completable

class ReminderRepository {
    val dao = ReminderDatabase.getInstanceWithoutContext().reminderDao()

    fun insertReminder(reminder: Reminder): Completable{
        return dao.insertReminder(reminder)
    }
}