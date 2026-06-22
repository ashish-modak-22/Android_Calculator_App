package com.example.calculator

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "calculator_history.db"
        private const val DATABASE_VERSION = 1

        // Creating the table and column names
        const val TABLE_NAME = "history"
        const val COLUMN_ID = "id"
        const val COLUMN_EXPRESSION = "expression"
        const val COLUMN_RESULT = "result"
    }

    // This function will get called when database is created for the first time
    override fun onCreate(db: SQLiteDatabase?) {

        // Creating the history table
        val createTable = """
            CREATE TABLE $TABLE_NAME(
               $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
               $COLUMN_EXPRESSION TEXT NOT NULL,
               $COLUMN_RESULT TEXT NOT NULL
            )
        """.trimIndent()

        db?.execSQL(createTable)  // It will start executing the sql query
    }

    // This function will get called when the database schema is incremented
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")  // It will delete the old table
        onCreate(db)        // Creating the new table
    }

    // Insertion of new calculation history
    fun insertHistory(expression: String, result: String): Boolean {
        val db = writableDatabase       // It will open the database in writable mode so that a new calculation history can be inserted

        val values = ContentValues().apply {
            put(COLUMN_EXPRESSION, expression)
            put(COLUMN_RESULT, result)
        }

        val success = db.insert(TABLE_NAME, null, values)  // It will return -1 for failure
        db.close()

        return success != -1L       // Save the history successfully for true operation
    }

    // Retrieves all the result history from the database
    fun getAllHistory() : List<HistoryModel>{
        val historyList = mutableListOf<HistoryModel>()
        val db = readableDatabase         // Open the database file in read mode

        // Query for getting all rows(newest rows first)
        val cursor = db.rawQuery(
            "SELECT $COLUMN_ID, $COLUMN_EXPRESSION, $COLUMN_RESULT FROM $TABLE_NAME ORDER BY $COLUMN_ID DESC",
            null
        )

        if(cursor.moveToFirst()){
            do {
               val item = HistoryModel(
                   id = cursor.getInt(0),
                   expression = cursor.getString(1),
                   result = cursor.getString(2)
               )
                historyList.add(item)
            } while (cursor.moveToNext())
        }

        cursor.close()             // Closing the cursor
        db.close()

        return historyList
    }
}