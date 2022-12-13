package com.example.cse226class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler(var context: Context,var arrayList: ArrayList<LinearPojo>,val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<AdapterRecycler.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecycler.MyHolder {
       val view : View = LayoutInflater.from(context).inflate(R.layout.custom_recycler_list,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRecycler.MyHolder, position: Int) {
        holder.versionName.text = arrayList[position].versionName
        holder.version.text = arrayList[position].version
        holder.img.setImageResource(arrayList[position].img)
        val user = arrayList[position]
        holder.bind(user,itemClickListener)
        holder.ll.setOnClickListener {
//            if(position==0){
//                Toast.makeText(context,"Android 12 is Clicked", Toast.LENGTH_SHORT).show()
//            }
//            if(position==1){
//                Toast.makeText(context,"Android 11 is Clicked", Toast.LENGTH_SHORT).show()
//            }
//            if(position==2){
//                Toast.makeText(context,"Android 10 is Clicked", Toast.LENGTH_SHORT).show()
//            }
//            if(position==3){
//                Toast.makeText(context,"Android 9 is Clicked", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyHolder(view: View):RecyclerView.ViewHolder(view){
        var versionName:TextView
        var version:TextView
        var img:ImageView
        var ll : LinearLayout


        init {
            version = view.findViewById(R.id.t1)
            versionName = view.findViewById(R.id.t2)
            img = view.findViewById(R.id.i1)
            ll = view.findViewById(R.id.ll1)
        }

        fun bind(user: LinearPojo, clickListener: OnItemClickListener){
            versionName.text = user.versionName
            version.text = user.version

            itemView.setOnClickListener{
                clickListener.onItemClicked(user)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(user: LinearPojo)
}