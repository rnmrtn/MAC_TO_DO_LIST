package com.martin.arciaga.calayag.mactodolist

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false
)
