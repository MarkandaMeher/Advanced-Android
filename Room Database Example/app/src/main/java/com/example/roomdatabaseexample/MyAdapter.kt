package com.example.roomdatabaseexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter(var mCtx : Context,var resource:Int,var items:List<Contact>) : ArrayAdapter<Contact>(mCtx,resource,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resource,null)

        val name:TextView = view.findViewById(R.id.nameListItem)
        val phone:TextView = view.findViewById(R.id.phoneListItem)
        val id:TextView = view.findViewById(R.id.idListItem)

        val mItem:Contact = getItem(position)!!

        name.text = mItem.name
        phone.text = mItem.phone.toString()
        id.text = mItem.id.toString()

        return view
    }

}