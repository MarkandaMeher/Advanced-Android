package com.example.sqlupdate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlupdate.R


class Update : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)


        // initializing all our variables.
        val NameEdt:EditText = findViewById(R.id.enterName)
        val AgeEdt:EditText = findViewById(R.id.enterAge)
        val updateBtn:Button = findViewById(R.id.updateName)

        // on below line we are initialing our dbhandler class.
        val db = DBHelper(this, null)

        // on below lines we are getting data which
        // we passed in our adapter class.
        val Name = getIntent().getStringExtra("name")
        val Age = getIntent().getStringExtra("age")

        // setting data to edit text
        // of our update activity.
        NameEdt.setText(Name)
        AgeEdt.setText(Age)

        // adding on click listener to our update course button.

        updateBtn.setOnClickListener {
            db.updateCourse(Name, NameEdt.getText().toString(), AgeEdt.getText().toString())

            Toast.makeText(this, "Updated...", Toast.LENGTH_SHORT).show()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

}