package com.graps.remindme.ui.inTake

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.graps.remindme.R
import com.graps.remindme.databinding.FragmentIntakeBinding
import com.graps.remindme.ui.base.BaseFragment

class IntakeFragment : BaseFragment<FragmentIntakeBinding>(R.layout.fragment_intake) {
    override val viewModel by activityViewModels<IntakeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentIntakeBinding =
        DataBindingUtil::inflate

    override fun setupView() {

    }
}