package com.graps.remindme.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.graps.remindme.R
import com.graps.remindme.data.Reminder
import com.graps.remindme.data.database.ReminderDatabase
import com.graps.remindme.data.repository.ReminderRepository
import com.graps.remindme.databinding.FragmentHomeBinding
import com.graps.remindme.ui.base.BaseFragment
import com.vivekkaushik.datepicker.OnDateSelectedListener
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) , View.OnClickListener{
    override val viewModel by activityViewModels<HomeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) ->
    FragmentHomeBinding = DataBindingUtil::inflate

    override fun setupView() {

        binding.datePickerTimeline.apply {
            setInitialDate(2021, 11, 24)
            setOnDateSelectedListener(object : OnDateSelectedListener {
                override fun onDateSelected(year: Int, month: Int, day: Int, dayOfWeek: Int) {
                    viewModel.getDate(year, month,day)

                }

                override fun onDisabledDateSelected(
                    year: Int,
                    month: Int,
                    day: Int,
                    dayOfWeek: Int,
                    isDisabled: Boolean
                ) {
                    TODO("Not yet implemented")
                }

            })

            val dates: Array<Date> = arrayOf<Date>(Calendar.getInstance().time)
            binding.datePickerTimeline.deactivateDates(dates)
        }

        binding.reminderRecycler.adapter = ReminderAdapter(mutableListOf(),
        object : ReminderInteractionListener{
        })

        binding.addFab.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        findNavController().navigate(R.id.action_homeFragment_to_intakeFragment)
    }
}