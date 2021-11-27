package com.graps.remindme.ui.inTake


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
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
            val timePicker = MaterialTimePicker.Builder().also {
                it.setHour(12).setTitleText("Set Time")
            }.build()

            val datePicker = datePickerBuilder.build()
            datePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                calendar.time = Date(it)
                val currentCalendar = "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH)}/${calendar.get(Calendar.YEAR)}"
                binding.reminder.setText(currentCalendar)

                viewModel.day.postValue(calendar.get(Calendar.DAY_OF_MONTH).toString())
                viewModel.month.postValue(calendar.get(Calendar.MONTH).toString())
                viewModel.year.postValue(calendar.get(Calendar.YEAR).toString())
            }

            timePicker.addOnPositiveButtonClickListener{
                val currentHour = "${Calendar.HOUR_OF_DAY}"
                val currentMinute = "${Calendar.MINUTE}"
                val currentSecond = "${Calendar.SECOND}"
                val currentTime =
                    binding.reminder.text.toString() + ", $currentHour" + ":"+
                            "$currentMinute" + ":" + "$currentSecond"
                binding.reminder.setText(currentTime)
            }
            timePicker.show(requireActivity().supportFragmentManager,"Calendar")
            datePicker.show(requireActivity().supportFragmentManager,"Calendar")
        }
        binding.done.setOnClickListener{ view->
            viewModel.addReminder()
            viewModel.amount.postValue(1)
            viewModel.dose.postValue("")
            viewModel.year.postValue("")
            viewModel.frequency.postValue("")
            viewModel.phoneNo.postValue("")
            viewModel.pillsName.postValue("")
           view.findNavController().popBackStack()
        }
    }
}