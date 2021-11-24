package com.graps.remindme.ui.inTake

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.google.android.material.datepicker.MaterialDatePicker
import com.graps.remindme.R
import com.graps.remindme.databinding.FragmentIntakeBinding
import com.graps.remindme.ui.base.BaseFragment
import java.util.*

class IntakeFragment : BaseFragment<FragmentIntakeBinding>(R.layout.fragment_intake) {
    override val viewModel by activityViewModels<IntakeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentIntakeBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.datePickerButton.setOnClickListener{
            val datePickerBuilder = MaterialDatePicker.Builder.datePicker().also {
                it.setTitleText("Set Date")
            }
            val datePicker = datePickerBuilder.build()
            datePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                calendar.time = Date(it)
                val currentCalendar = "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH)}/${calendar.get(Calendar.YEAR)}"
                binding.reminder.setText(currentCalendar)
            }
            datePicker.show(requireActivity().supportFragmentManager,"Calendar")
        }
    }
}