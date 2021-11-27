package com.graps.remindme.data.repository

import com.graps.remindme.data.Reminder
import com.graps.remindme.data.database.ReminderDatabase

class ReminderRepository {
    private val dao = ReminderDatabase.getInstanceWithoutContext().reminderDao()

    fun insertReminder(reminder: Reminder) =
        dao.insertReminder(reminder)

    fun retrieveRemindersDependingOnDate(year: String, month: String, day: String) =
        dao.getRemindersForADate(year, month, day)
}