package com.example.hw_3_4.ui.home.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_3_4.App
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.FragmentAddProjectBinding
import com.example.hw_3_4.databinding.FragmentAllPrpojectsBinding
import com.example.hw_3_4.databinding.FragmentCategoryABinding
import com.example.hw_3_4.databinding.FragmentCategoryBBinding
import com.example.hw_3_4.models.Project
import com.example.hw_3_4.ui.home.project_adapter.ProjectAdapter

class AllProjectsFragment : Fragment() {


    private var _binding: FragmentAllPrpojectsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllPrpojectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProjectAdapter(this::onClick)
        val list = App.db.taskDao().getAllProjects()
        Log.e("ololo", "onViewCreated: $list")
        adapter.setProjects(list)
        binding.rvProjects.adapter = adapter
        binding.rvProjects.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun onClick(project: Project) {
        val bundle = Bundle()
        bundle.putLong("projectId",project.id)
        val id = project.id
        Log.e("ololo", "onClick: $id", )
        findNavController().navigate(R.id.taskFragment,bundle)
    }


}