package com.example.locationexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ReverseGeoCoderExample : AppCompatActivity() {

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse_geo_coder_example)

        val lo = findViewById<EditText>(R.id.longitude1)
        val la = findViewById<EditText>(R.id.latitude1)
        val find = findViewById<Button>(R.id.search)


        find.setOnClickListener {

            latitude = la.text.toString().toDouble()
            longitude = lo.text.toString().toDouble()

            val uri = Uri.parse("geo:${latitude}, $longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

    }
}