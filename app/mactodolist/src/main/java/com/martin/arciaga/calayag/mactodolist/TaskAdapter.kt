package com.martin.arciaga.calayag.mactodolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private var tasks: MutableList<Task>,
    private val onEdit: (Task) -> Unit,
    private val onDelete: (Task) -> Unit,
    private val onComplete: (Task, Boolean) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.txtTaskTitle)
        val description: TextView = view.findViewById(R.id.txtTaskDescription)
        val completed: CheckBox = view.findViewById(R.id.checkCompleted)
        val edit: Button = view.findViewById(R.id.btnEdit)
        val delete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.title.text = task.title
        holder.description.text = task.description

        holder.completed.setOnCheckedChangeListener(null)
        holder.completed.isChecked = task.completed

        holder.completed.setOnCheckedChangeListener { _, isChecked ->
            onComplete(task, isChecked)
        }

        holder.edit.setOnClickListener {
            onEdit(task)
        }

        holder.delete.setOnClickListener {
            onDelete(task)
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: MutableList<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}