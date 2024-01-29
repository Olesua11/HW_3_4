package com.example.hw_3_4.ui.home.ALL

import Task
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_3_4.R
import com.example.hw_3_4.App
import com.example.hw_3_4.databinding.FragmentCategoryBBinding
import com.example.hw_3_4.ui.notifications.AllTasksFragment
import com.example.hw_3_4.ui.notifications.ListAdapter

class CategoryBFragment : Fragment() {

    private var _binding: FragmentCategoryBBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = ListAdapter(this::onItemClick)
        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())

        val list = App.db.taskDao().getAllTasks()
        adapter.setTasks(list)

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_taskEditFragment, )
        }
    }

    private fun onItemClick(task: Task) {
        val bundle = bundleOf(AllTasksFragment.KEY_TASK_EDIT to task)
        findNavController().navigate(R.id.taskEditFragment, bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}