package com.example.attemptapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter  = ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val toDoTitle = etToDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(toDoTitle, false)
                toDoAdapter.addToDo(toDo)
                etToDoTitle.text.clear()
            }

        }
        btnDeleteToDo.setOnClickListener {
            toDoAdapter.deleteDoneToDo()
        }
    }
}