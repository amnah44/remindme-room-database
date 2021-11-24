package com.graps.remindme.data.repository

import com.graps.remindme.data.Reminder
import com.graps.remindme.data.database.ReminderDatabase

class ReminderRepository {
    val dao = ReminderDatabase.getInstanceWithoutContext().reminderDao()

    fun insertReminder(reminder: Reminder) =
        dao.insertReminder(reminder)

    fun deleteReminder(reminder: Reminder) =
        dao.deleteReminder(reminder)

    fun updateReminder(reminder: Reminder) =
        dao.updateReminder(reminder)

    fun retrieveRemindersDependingOnDate(year: String, month: String, day: String) =
        dao.getFilteredReminders("$year", "$month", "$day")
}