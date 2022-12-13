package com.example.cse226class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewDemo : AppCompatActivity(),OnItemClickListener {
    lateinit var arrayList: ArrayList<LinearPojo>
    lateinit var recyclerView: RecyclerView
    lateinit var adapterRecycler: AdapterRecycler
    override fun onItemClicked(user:LinearPojo){
        Toast.makeText(this,"User name${user.versionName} \n Number : ${user.version}",Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_demo)

        var ll1 = findViewById<LinearLayout>(R.id.ll1)

        linearListData()
        recyclerView = findViewById(R.id.recyclerViewLinear)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager=LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager=linearLayoutManager
        adapterRecycler = AdapterRecycler(this,arrayList, this)
        recyclerView.adapter=adapterRecycler



    }


    fun linearListData(){
        arrayList = ArrayList<LinearPojo>()
        arrayList.add(LinearPojo(R.drawable.android,"Android 12","12"))
        arrayList.add(LinearPojo(R.drawable.android,"Android 11","11"))
        arrayList.add(LinearPojo(R.drawable.android,"Android 10","10"))
        arrayList.add(LinearPojo(R.drawable.android,"Android 9","9"))
    }
}