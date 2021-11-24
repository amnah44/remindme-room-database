package com.graps.remindme.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.graps.remindme.data.Reminder
import java.security.AccessControlContext

@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDatabase : RoomDatabase() {

    abstract fun reminderDao() : ReminderDao

    companion object{

        private const val Database_Name = "Reminder Database"

        @Volatile private var instance: ReminderDatabase? = null

        fun getInstance(context :Context): ReminderDatabase{
        return instance?: synchronized(this){ buildDatabase(context).also { instance = it }}
        }

        fun getInstanceWithoutContext(): ReminderDatabase{
            return instance!!
        }

        private fun buildDatabase(context: Context): ReminderDatabase{
         return Room.databaseBuilder(context, ReminderDatabase::class.java, Database_Name).build()
        }
    }
}