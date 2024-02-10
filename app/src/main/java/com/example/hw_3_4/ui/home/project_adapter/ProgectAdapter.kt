package com.example.hw_3_4.ui.home.project_adapter


import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3_4.App
import com.example.hw_3_4.R
import com.example.hw_3_4.databinding.ItemProgectBinding
import com.example.hw_3_4.models.Project
import com.example.hw_3_4.ui.notifications.ListAdapter
import java.util.Calendar

class ProjectAdapter(
    private val onClick: (project: Project) -> Unit,
) : RecyclerView.Adapter<ProjectViewHolder>() {

    private var projects = emptyList<Project>()

    fun setProjects(projects: List<Project>) {
        this.projects = projects
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = ItemProgectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProjectViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.onBind(projects[position])

        /*    holder.itemView.setOnClickListener { view ->
                navigateToProjectDetailsFragment(view, projects[position].name, position)
            }*/
    }

    private fun navigateToProjectDetailsFragment(
        view: View,
        projectName: String,
        position: Int
    ) {
        /*        val action = NotificationsFragmentDirections.actionNavigationNotificationsToProjectDetailsFragment(
                    projectName = projectName,
                    position = position
                )
                Navigation.findNavController(view).navigate(action)*/
    }
}

class ProjectViewHolder(
    private val binding: ItemProgectBinding,
    private val onClick: (project: Project) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(project: Project) {
        val currentDate = Calendar.getInstance()
        val currentDay = currentDate.get(Calendar.DATE)
        itemView.setOnClickListener {
            onClick(project)
        }
        with(binding) {
            tvName.text = project.name
            if (project.persentage == 100) {
                flStatusColor.setBackgroundColor(Color.GREEN)
            } else if (project.persentage != 100 && project.deadlineDay > currentDay) {
                flStatusColor.setBackgroundColor(Color.RED)
            } else {
                flStatusColor.setBackgroundColor(Color.YELLOW)
            }
            when (project.category) {
                "Home" -> imgCategory.setBackgroundResource(R.drawable.ic_home)
                "School" -> imgCategory.setBackgroundResource(R.drawable.ic_school)
                "Work" -> imgCategory.setBackgroundResource(R.drawable.ic_assured_workload)
            }
        }
    }
}
