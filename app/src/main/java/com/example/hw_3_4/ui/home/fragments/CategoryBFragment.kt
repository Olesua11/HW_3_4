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
import com.example.hw_3_4.databinding.FragmentCategoryBBinding
import com.example.hw_3_4.models.Project
import com.example.hw_3_4.ui.home.project_adapter.ProjectAdapter
import com.example.hw_3_4.ui.notifications.ListAdapter

class CategoryBFragment : Fragment() {

    private var _binding: FragmentCategoryBBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = ProjectAdapter(this::onClick)
        binding.rvProjects.adapter = adapter
        binding.rvProjects.layoutManager = LinearLayoutManager(requireContext())
        val list = App.db.taskDao().getProjectsByCategory("Work")
        adapter.setProjects(list)

    }
    private fun onClick(project: Project) {
        val bundle = Bundle()
        bundle.putLong("projectId",project.id)
        val id = project.id
        Log.e("ololo", "onClick: $id", )
        findNavController().navigate(R.id.taskFragment,bundle)
    }



}