package com.graps.remindme.util

import android.telephony.SmsManager

object SmsSender {
    fun sendSMS(phoneNo :String,msg: String,) {
        val mySmsManager = SmsManager.getDefault()
        mySmsManager.sendTextMessage(phoneNo, null, msg, null, null)
    }
}