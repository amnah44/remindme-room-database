package com.graps.remindme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.graps.remindme.R
import com.graps.remindme.data.database.ReminderDatabase

class RemindMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remind_me)
    }
}