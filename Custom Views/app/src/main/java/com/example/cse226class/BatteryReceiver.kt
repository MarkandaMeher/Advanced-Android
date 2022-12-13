package com.example.cse226class

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class BatteryReceiver constructor(var tv : TextView) : BroadcastReceiver() {

    override fun onReceive(p0: Context, p1: Intent){

        val perc = p1.getIntExtra("lavel",10)
        if(perc != 0){
            tv.text = "$perc"
        }

    }
}