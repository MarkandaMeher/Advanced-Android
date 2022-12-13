package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,
        ContactDatabase::class.java,
        "contactDB").build()

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0,"virrat",99999))
        }
    }

    fun getData(view: View) {
        database.contactDAO().getContact().observe(this){
            Log.d("Room",it.toString())
        }
    }
}