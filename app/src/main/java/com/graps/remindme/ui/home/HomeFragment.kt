package com.graps.remindme.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.graps.remindme.R
import com.graps.remindme.data.DateAndTimeSource
import com.graps.remindme.databinding.FragmentHomeBinding
import com.graps.remindme.ui.base.BaseFragment
import com.graps.remindme.util.SmsSender
import com.vivekkaushik.datepicker.OnDateSelectedListener
import java.util.*


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home),
    View.OnClickListener {
    override val viewModel by activityViewModels<HomeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) ->
    FragmentHomeBinding = DataBindingUtil::inflate

    private val getDate = DateAndTimeSource()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun setupView() {


        activity?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS),
                PackageManager.PERMISSION_GRANTED
            )
        }
        SmsSender.sendSMS("012345678","Helllo")


        with(viewModel) {
            getRemindersDependingOnDate(
                getDate.getLocalDate().year,
                getDate.getLocalDate().month.value - 1,
                getDate.getLocalDate().dayOfMonth
            )
        }

        binding.datePickerTimeline.apply {
            setActiveDate(getDate.getLocalCalendar())
            setInitialDate(2021, 10, 24)

            setOnDateSelectedListener(object : OnDateSelectedListener {
                override fun onDateSelected(year: Int, month: Int, day: Int, dayOfWeek: Int) {
                    viewModel.getRemindersDependingOnDate(year, month, day)
                }

                override fun onDisabledDateSelected(
                    year: Int,
                    month: Int,
                    day: Int,
                    dayOfWeek: Int,
                    isDisabled: Boolean
                ) {

                }
            })
        }
        binding.reminderRecycler.adapter = ReminderAdapter(mutableListOf(),
            object : ReminderInteractionListener {
            })

        binding.addFab.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        findNavController().navigate(R.id.action_homeFragment_to_intakeFragment)
    }
}