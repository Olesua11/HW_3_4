package com.example.hw_3_4.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3_4.databinding.ItemListBinding
import com.example.hw_3_4.models.Task
import com.example.hw_3_4.ui.home.HomeFragmentDirections

class ListAdapter(
    private val onCheckBoxClick: (task:Task) -> Unit
) : RecyclerView.Adapter<ListViewHolder>() {

    private var tasks = emptyList<Task>()

    fun setTasks(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding, onCheckBoxClick)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(tasks[position])

        /*holder.itemView.setOnClickListener { view ->
            navigateToTaskEditFragment(view, tasks[position].title, position, false)
        }*/
    }

    private fun navigateToTaskEditFragment(
        view: View,
        taskDescription: String,
        position: Int,
        addTask: Boolean
    ) {
        val action = HomeFragmentDirections.actionNavigationHomeToTaskEditFragment(
            argtext = taskDescription,
            position = position,
            addtask = addTask
        )
        Navigation.findNavController(view).navigate(action)
    }
}

class ListViewHolder(
    private val binding: ItemListBinding,
    private val onCheckBoxClick: ( task:Task) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(task: Task) {
        with(binding) {
            cbDone.isChecked = task.checkBox
            tvDesc.text = task.description
            cbDone.setOnClickListener {
                onCheckBoxClick(task)
            }
        }
    }
}
