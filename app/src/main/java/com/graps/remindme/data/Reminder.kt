package com.graps.remindme.data

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reminder_table")
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String?,
    val doseAmount: Int?,
    @ColumnInfo(name = "Year") val year: String?,
    @ColumnInfo(name = "Month") val month: String?,
    @ColumnInfo(name = "Day") val day: String?,
    val image: Image?
)