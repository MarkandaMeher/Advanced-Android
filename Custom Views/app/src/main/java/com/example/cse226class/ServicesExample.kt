package com.example.cse226class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServicesExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_example)

        val start = findViewById<Button>(R.id.button2)
        val stop = findViewById<Button>(R.id.button3)

        val newSer = Intent(this,NewService::class.java)

        start.setOnClickListener {
            startService(newSer)
        }
        stop.setOnClickListener {
            stopService(newSer)
        }

    }
}