package com.martin.arciaga.calayag.mactodolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var storage: TaskStorage
    private lateinit var btnAddTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        storage = TaskStorage(this)
        recyclerView = findViewById(R.id.recyclerViewTasks)
        btnAddTask = findViewById(R.id.btnAddTask)

        recyclerView.layoutManager = LinearLayoutManager(this)

        btnAddTask.setOnClickListener {
            val intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(intent)
        }

        loadTasks()
    }

    override fun onResume() {
        super.onResume()
        loadTasks()
    }

    private fun loadTasks() {
        val tasks = storage.loadTasks()
        
        adapter = TaskAdapter(
            tasks = tasks,
            onEdit = { task ->
                val intent = Intent(this, AddEditTaskActivity::class.java)
                intent.putExtra("TASK_ID", task.id)
                startActivity(intent)
            },
            onDelete = { task ->
                tasks.remove(task)
                storage.saveTasks(tasks)
                adapter.updateTasks(tasks)
            },
            onComplete = { task, isChecked ->
                task.completed = isChecked
                storage.saveTasks(tasks)
            }
        )
        
        recyclerView.adapter = adapter
    }
}
