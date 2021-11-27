package com.graps.remindme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.graps.remindme.R
import com.graps.remindme.data.database.ReminderDatabase
import com.graps.remindme.databinding.ActivityRemindMeBinding

class RemindMeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRemindMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.splashScreenTheme)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_remind_me)
        ReminderDatabase.getInstance(applicationContext)
    }
}