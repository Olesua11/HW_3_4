package com.example.hw_3_4.ui.notifications

import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3_4.databinding.ItemListBinding

class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(task: ListTasks) {
        with(binding) {
            itemListTask.text = task.name

        }
    }
}