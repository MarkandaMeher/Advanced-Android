package com.example.cse226class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast

class CoustemListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coustem_list_view)

        var listView = findViewById<ListView>(R.id.listView1)
        var list = mutableListOf<Model>()

        list.add(Model("Facebook","facebook description",R.drawable.fb))
        list.add(Model("Skype","skype description",R.drawable.skype))
        list.add(Model("Twitter","twitter description",R.drawable.twitter))
        list.add(Model("Youtube","youtube description",R.drawable.youtube))

        listView.adapter = MyAdapter(this,R.layout.row,list)
        listView.setOnItemClickListener { parent:AdapterView<*>,view:View,position:Int,id:Long->

            if(position==0)
                Toast.makeText(applicationContext,"FaceBook is Clicked",Toast.LENGTH_SHORT).show()


        }

    }
}