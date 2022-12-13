package com.example.cse226class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast

class CustomGridView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_grid_view)


        var listView = findViewById<GridView>(R.id.gView)
        var list = mutableListOf<Items>()

        list.add(Items(R.drawable.fb,"Facebook"))
        list.add(Items(R.drawable.skype,"Skype"))
        list.add(Items(R.drawable.twitter,"Twitter"))
        list.add(Items(R.drawable.youtube,"Youtube"))
        list.add(Items(R.drawable.img1,"Img1"))
        list.add(Items(R.drawable.img2,"Img2"))
        list.add(Items(R.drawable.img3,"Img3"))
        list.add(Items(R.drawable.img4,"Img4"))
        list.add(Items(R.drawable.img5,"Img5"))
        list.add(Items(R.drawable.img6,"Img6"))
        list.add(Items(R.drawable.img7,"Img7"))
        list.add(Items(R.drawable.img8,"Img8"))
        list.add(Items(R.drawable.img9,"img9"))
        list.add(Items(R.drawable.img10,"Img10"))

        listView.adapter = MyAdapter2(this,R.layout.custom_view,list)
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id:Long->

            if(position==0)
                Toast.makeText(applicationContext,"FackeBook is Clicked", Toast.LENGTH_SHORT).show()


        }



    }
}