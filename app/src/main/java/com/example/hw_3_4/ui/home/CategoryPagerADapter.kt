package com.example.hw_3_4.ui.home.ALL

import androidx.fragment.app.Fragment


import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_3_4.ui.home.fragments.AllProjectsFragment
import com.example.hw_3_4.ui.home.fragments.CategoryAFragment
import com.example.hw_3_4.ui.home.fragments.CategoryBFragment
import com.example.hw_3_4.ui.home.fragments.SchoolFragment

class CategoryPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: androidx.lifecycle.Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf<Fragment>(
        AllProjectsFragment(),
        CategoryAFragment(),
        CategoryBFragment(),
        SchoolFragment()
    )

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllProjectsFragment()
            1 -> CategoryAFragment()
            3 -> SchoolFragment()
            2 -> CategoryBFragment()
            else -> AllProjectsFragment()
        }
    }
}