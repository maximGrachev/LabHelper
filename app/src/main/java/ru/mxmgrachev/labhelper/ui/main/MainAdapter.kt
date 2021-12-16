package ru.mxmgrachev.labhelper.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mxmgrachev.labhelper.data.entity.Lab
import ru.mxmgrachev.labhelper.databinding.LabItemBinding

class MainAdapter(val clickListener: LabListener) :
    ListAdapter<Lab, MainAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: LabItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Lab, clickListener: LabListener) {
            binding.lab = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LabItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<Lab>() {
    override fun areItemsTheSame(oldItem: Lab, newItem: Lab): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lab, newItem: Lab): Boolean {
        return oldItem == newItem
    }

}

class LabListener(val clickListener: (labId: Int) -> Unit) {
    fun onClick(lab: Lab) = clickListener(lab.id)
}

