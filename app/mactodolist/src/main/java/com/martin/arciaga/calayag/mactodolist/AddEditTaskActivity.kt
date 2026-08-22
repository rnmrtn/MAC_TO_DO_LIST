package com.martin.arciaga.calayag.mactodolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddEditTaskActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var btnSaveTask: Button
    private lateinit var btnCancel: Button
    private lateinit var txtScreenTitle: TextView

    private lateinit var storage: TaskStorage
    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_task)

        txtScreenTitle = findViewById(R.id.txtScreenTitle)
        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        btnSaveTask = findViewById(R.id.btnSaveTask)
        btnCancel = findViewById(R.id.btnCancel)

        storage = TaskStorage(this)

        taskId = intent.getIntExtra("TASK_ID", -1)

        if (taskId != -1) {
            txtScreenTitle.text = "Edit Task"
            btnSaveTask.text = "Update Task"
            loadTask()
        }

        btnSaveTask.setOnClickListener {
            saveTask()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun loadTask() {
        val tasks = storage.loadTasks()
        val task = tasks.find { it.id == taskId }

        if (task != null) {
            etTitle.setText(task.title)
            etDescription.setText(task.description)
        }
    }

    private fun saveTask() {
        val title = etTitle.text.toString().trim()
        val description = etDescription.text.toString().trim()

        if (title.isEmpty()) {
            etTitle.error = "Task title is required"
            return
        }

        val tasks = storage.loadTasks()

        if (taskId == -1) {
            val nextId = if (tasks.isEmpty()) {
                1
            } else {
                tasks.maxOf { it.id } + 1
            }

            tasks.add(
                Task(
                    id = nextId,
                    title = title,
                    description = description
                )
            )
        } else {
            val task = tasks.find { it.id == taskId }

            if (task != null) {
                task.title = title
                task.description = description
            }
        }

        storage.saveTasks(tasks)
        finish()
    }
}