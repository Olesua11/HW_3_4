
package com.example.hw_3_4.ui.home

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.FragmentHomeBinding
import com.example.hw_3_4.ui.home.ALL.CategoryPagerAdapter
import com.google.android.material.tabs.TabLayout
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

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)

        val pagerAdapter = CategoryPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Category A"
                2 -> tab.text = "Category B"
            }
        }.attach()


    }

    /*  private fun updateExistingTask(resultText: String, position: Int) {
          val taskUpdate = ""
      }

      private fun updateRecyclerView() {
              val list = App.db.taskDao().getAllTasks()
              val adapter = ListAdapter(this::onItemClick )
              binding.taskRecyclerView.adapter = adapter
      }*/


    /*private fun onItemClick(position: Int) {
        findNavController().navigate()
    }
*/

    /*  setFragmentResultListener(TaskEditFragment.KEY1) { _, bundle ->
            val resultText = bundle.getString("argtext", "")
            val position = bundle.getInt("position", -1)
            val addTask = bundle.getBoolean("addtask", false)

            if (resultText.isNotEmpty()) {
                if (addTask) {
                    addNewTask(resultText)
                } else {
                    updateExistingTask(resultText, position)
                }
            }
        }*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
