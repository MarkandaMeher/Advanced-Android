package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Example3 : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

        database = Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contactDB").build()

        listView = findViewById<ListView>(R.id.lview3)

        val adapter = MyAdapter(this,R.layout.listitem, mutableListOf())
        listView.adapter=adapter



        GlobalScope.launch(Dispatchers.IO) {
            database.contactDAO().insertContact(Contact(0,"piyush", 200001))
            database.contactDAO().insertContact(Contact(0,"meher", 200002))
            database.contactDAO().insertContact(Contact(0,"piyush", 200003))
            database.contactDAO().insertContact(Contact(0,"meher", 200004))
            database.contactDAO().insertContact(Contact(0,"piyush", 200005))
        }

        database.contactDAO().getNameData("piyush").observe(this) {
            adapter.clear()
            adapter.addAll(it)
        }

    }
}