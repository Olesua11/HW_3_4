package com.example.hw_3_4.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.Data.local.Pref
import com.example.hw_3_4.databinding.FragmentOnBoardingBinding
import com.example.hw_3_4.ui.notifications.OnBoardingAdapter
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    private val adapter = OnBoardingAdapter(this::onClick)

    private  val  pref by lazy {
        Pref(requireContext())
    }

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
    }


}
