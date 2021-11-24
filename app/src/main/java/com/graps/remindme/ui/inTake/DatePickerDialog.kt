package com.graps.remindme.ui.inTake


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.graps.remindme.R

class DatePickerDialog : DialogFragment (){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.date_picker_dialog, null))
                .setPositiveButton("Set",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.dismiss()
                    })
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}