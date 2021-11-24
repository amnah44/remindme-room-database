package com.graps.remindme.ui.inTake


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DatePickerDialog : DialogFragment (){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Choose Date")
                .setPositiveButton("Set",DialogInterface.OnClickListener{ dialog, id ->

                })
                .setNegativeButton("Cancel",DialogInterface.OnClickListener{ dialog, id ->

                })
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}