package com.example.hw_3_4.ui.home.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_3_4.App
import com.example.hw_3_4.databinding.FragmentTaskEditBinding
import com.example.hw_3_4.models.Task

class TaskEditFragment : Fragment() {

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("ololo", "onViewCreated: edit fragment opened")

        val projectId = arguments?.getLong("id")
        Log.e("ololo", "onViewCreated: $projectId", )

        binding.saveButton.setOnClickListener {
            if (projectId != null) {
                val task = Task(
                    status = "",
                    dueDate = 0,
                    description = binding.etDesc.text.toString(),
                    projectId = projectId,
                    checkBox = false
                )
                Log.e("ololo", "onViewCreated: $task", )
                App.db.taskDao().insertTask(task)
                findNavController().navigateUp()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.e("ololo", "onDestroyView: EditFragment")
    }
}
