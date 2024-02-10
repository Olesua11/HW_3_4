package com.example.hw_3_4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.FragmentHomeBinding
import com.example.hw_3_4.ui.home.ALL.CategoryPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = CategoryPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Home"
                2 -> tab.text = "Work"
                3-> tab.text = "School"
            }
        }.attach()
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.addProjectFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
