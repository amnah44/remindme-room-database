package com.graps.remindme.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.graps.remindme.R
import com.graps.remindme.databinding.FragmentHomeBinding
import com.graps.remindme.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel by activityViewModels<HomeViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) ->
    FragmentHomeBinding = DataBindingUtil::inflate

    override fun setupView() {

    }

}