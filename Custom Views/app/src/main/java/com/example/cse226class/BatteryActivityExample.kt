package com.example.cse226class

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BatteryActivityExample : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var br : BatteryReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_example)

        tv = findViewById(R.id.textView3)
        br = BatteryReceiver(tv)

        registerReceiver(br, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}