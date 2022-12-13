package com.example.locationexample

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class ReverseGeoCoder : AppCompatActivity() {

    private val LOCATION_PERMISSION_REQ_CODE = 1000;
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var find: Button
    private lateinit var tvLatitude: TextView
    private lateinit var tvLongitude: TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse_geo_coder)

        find = findViewById(R.id.button)
        tvLatitude = findViewById(R.id.textView2)
        tvLongitude = findViewById(R.id.textView4)
        editText = findViewById(R.id.editTextTextPersonName)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        find.setOnClickListener {
            if(editText.text.toString().isEmpty()){
                Toast.makeText(this,"Enter Address",Toast.LENGTH_SHORT).show()
            }
            else{
                getLocationFromAddress(editText.text.toString())
            }
        }

    }
    private fun getLocationFromAddress(location: String){
        val geoCoder = Geocoder(this)
        val list:List<Address> = geoCoder.getFromLocationName(location,5)
        if(list.isNullOrEmpty()){
            return
        }
        tvLatitude.text = list[0].latitude.toString()
        tvLongitude.text = list[0].longitude.toString()

        


    }

}