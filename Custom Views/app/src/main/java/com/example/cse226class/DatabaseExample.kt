package com.example.cse226class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DatabaseExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_example)

        var name = findViewById<EditText>(R.id.editTextTextPersonName)
        var age = findViewById<EditText>(R.id.age)
        val add = findViewById<Button>(R.id.button4)
        val show = findViewById<Button>(R.id.button5)

        val Tname = findViewById<TextView>(R.id.textView5)
        val Tage = findViewById<TextView>(R.id.textView6)




    }
}