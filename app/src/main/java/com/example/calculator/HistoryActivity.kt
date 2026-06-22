package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var recyclerHistory: RecyclerView
    private lateinit var btnBack: AppCompatImageButton
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        recyclerHistory = findViewById(R.id.recyclerHistory)
        btnBack = findViewById(R.id.btnBack)

        dbHelper = DatabaseHelper(this)

        setupRecyclerview()

        // Functionality of back button
        btnBack.setOnClickListener {
            finish()                 // Finish closes the current activity
        }
    }

    private fun setupRecyclerview(){

        val historyList = dbHelper.getAllHistory()

        // Using the LinearLayout which will manage the list of items in vertical list
        recyclerHistory.layoutManager = LinearLayoutManager(this)

        // Creating adapter
        recyclerHistory.adapter = HistoryAdapter(historyList)
    }
}