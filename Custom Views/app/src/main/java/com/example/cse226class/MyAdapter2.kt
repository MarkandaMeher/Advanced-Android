package com.example.cse226class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter2( context: Context, var resource: Int, var objects: MutableList<Items>) :
    ArrayAdapter<Items>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resource,null)
        val imageView: ImageView = view.findViewById(R.id.imageview22)
        val titleTextView: TextView = view.findViewById(R.id.textview22)

        val mItem:Items = objects[position]
        imageView.setImageDrawable(context.resources.getDrawable(mItem.Img))
        titleTextView.text=mItem.title


        return view

    }

}