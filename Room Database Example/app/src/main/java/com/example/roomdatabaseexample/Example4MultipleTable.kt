package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Example4MultipleTable : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example4_multiple_table)

        database = Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contactDB").build()

        GlobalScope.launch {
            database.contactDAO().insertUsers(Users(0,"virrat@gmail.com",9999999,"Meher"))
        }

    }
}