package com.example.cse226class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView

class ImageVectorAssectExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_vector_assect_example)

        val i1 = findViewById<EditText>(R.id.input1)
        val i2 = findViewById<EditText>(R.id.input2)
        val r = findViewById<TextView>(R.id.result)

        var i = i1.text
        var j = i2.text





    }
}