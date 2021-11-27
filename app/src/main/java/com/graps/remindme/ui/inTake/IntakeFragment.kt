package com.graps.remindme.ui.inTake


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.graps.remindme.R
import com.graps.remindme.databinding.FragmentIntakeBinding
import com.graps.remindme.ui.base.BaseFragment
import com.graps.remindme.util.AppearanceList
import java.util.*

class IntakeFragment : BaseFragment<FragmentIntakeBinding>(R.layout.fragment_intake), View.OnClickListener {
    override val viewModel by activityViewModels<IntakeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentIntakeBinding =
        DataBindingUtil::inflate

    override fun setupView() {

        binding.recyclerAppearance.adapter =AppearanceAdapter(AppearanceList().appearanceList,viewModel)


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
                    binding.reminder.text.toString() + ", $currentHour" + ":"+ currentMinute + ":" + currentSecond
                binding.reminder.setText(currentTime)
            }
            timePicker.show(requireActivity().supportFragmentManager,"Calendar")
            datePicker.show(requireActivity().supportFragmentManager,"Calendar")
        }
        binding.done.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        this.viewModel.addReminder()
        findNavController().popBackStack()
    }
}