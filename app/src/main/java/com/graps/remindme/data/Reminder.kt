package com.graps.remindme.data

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reminder_table")
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String?,
    val doseAmount: Int?,
    val timeToTake: String?,
    val image: Image?
)