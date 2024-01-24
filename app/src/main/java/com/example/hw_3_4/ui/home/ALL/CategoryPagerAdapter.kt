package com.example.hw_3_4.ui.home.ALL

import androidx.fragment.app.Fragment


import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_3_4.ui.home.ALL.AllTasksFragment
import com.example.hw_3_4.ui.home.ALL.CategoryAFragment
import com.example.hw_3_4.ui.home.ALL.CategoryBFragment

class CategoryPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: androidx.lifecycle.Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllTasksFragment()
            1 -> CategoryAFragment()
            2 -> CategoryBFragment()
            else -> AllTasksFragment()
        }
    }
}