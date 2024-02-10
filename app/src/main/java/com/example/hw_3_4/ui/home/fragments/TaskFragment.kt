package com.example.hw_3_4.ui.home.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.App
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.FragmentTaskBinding
import com.example.hw_3_4.models.Task
import com.example.hw_3_4.ui.notifications.ListAdapter
import java.util.Calendar

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private var persentage = 0
    private var list = listOf<Task>()
    private var oneTaskPersantage = 0
    private var projectId: Long? = 0
    private var counter = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projectId = arguments?.getLong("projectId")
        Log.e("ololo", "taskFragment: $projectId ")

        binding.btnAddTasks.setOnClickListener {
            val bundle = bundleOf("id" to projectId)
            findNavController().navigate(R.id.taskEditFragment, bundle)
        }
        if (projectId != null) {
            list = App.db.taskDao().getTasksByPId(projectId!!)
        }

        val adapter = ListAdapter(this::onCheckBoxClick)
        adapter.setTasks(list)
        binding.rvTasks.adapter = adapter
        Log.e("ololo", "taskFragment: $list ")


        if (list.isNotEmpty()) {
            persentage = 100 / list.size
            Log.e("ololo", "taskFragment: $list ")
        }

    }

    private fun onCheckBoxClick(task: Task) {
        if (projectId != null) {
            if (!task.checkBox) {
                counter++
                App.db.taskDao().updateTaskCheckBoxById(true, task.id)
            } else {
                App.db.taskDao().updateTaskCheckBoxById(false, task.id)
                counter--
            }
            if (counter == list.size && projectId != null) {
                persentage = 100
                App.db.taskDao().updateProjectPersentageById(persentage, projectId!!)
            }
        }
    }
}