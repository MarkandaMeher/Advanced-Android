package com.example.cse226class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

//class MyAdapter(var mCtx:Context,var resources:Int,var items:List<Model>):ArrayAdapter<Model>(mCtx,resources,items) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
//        val view:View = layoutInflater.inflate(resources,null)
//        val imageView:ImageView = view.findViewById(R.id.Image1)
//        val titleTextView:TextView = view.findViewById(R.id.textView1)
//        val descriptionTextView:TextView = view.findViewById(R.id.textView2)
//
//        val mItem:Model = items[position]
//        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
//        titleTextView.text=mItem.title
//        descriptionTextView.text=mItem.description
//
//        return view
//    }
//}
    class MyAdapter(var mCtx:Context,var resources:Int,var items:List<Model>):BaseAdapter() {
    private lateinit var serialNum: TextView
    private lateinit var name: TextView
    private lateinit var contactNum: TextView
    override fun getCount(): Int {
        return items.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)
        val imageView:ImageView = view.findViewById(R.id.Image1)
        val titleTextView:TextView = view.findViewById(R.id.textView1)
        val descriptionTextView:TextView = view.findViewById(R.id.textView2)

        val mItem:Model = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text=mItem.title
        descriptionTextView.text=mItem.description

        return view
    }
}