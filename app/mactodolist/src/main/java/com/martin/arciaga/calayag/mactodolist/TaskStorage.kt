package com.martin.arciaga.calayag.mactodolist

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class TaskStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "todo_preferences",
        Context.MODE_PRIVATE
    )

    fun saveTasks(tasks: List<Task>) {
        val array = JSONArray()

        tasks.forEach { task ->
            val obj = JSONObject()
            obj.put("id", task.id)
            obj.put("title", task.title)
            obj.put("description", task.description)
            obj.put("completed", task.completed)
            array.put(obj)
        }

        prefs.edit()
            .putString("tasks", array.toString())
            .apply()
    }

    fun loadTasks(): MutableList<Task> {
        val result = mutableListOf<Task>()
        val json = prefs.getString("tasks", null) ?: return result

        val array = JSONArray(json)

        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)

            result.add(
                Task(
                    id = obj.getInt("id"),
                    title = obj.getString("title"),
                    description = obj.getString("description"),
                    completed = obj.getBoolean("completed")
                )
            )
        }

        return result
    }
}
