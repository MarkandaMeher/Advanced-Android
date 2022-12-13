package com.example.sqlupdate

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter2(var mCtx: Context, var resources: Int, var items: MutableList<Contact>) :
    ArrayAdapter<Contact>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val mItem: Contact = items[position]


        view.setOnLongClickListener {
            /*val db = DBHelper(mCtx, null)
            if(db.del(mItem.Name)) {
                Toast.makeText(mCtx, "Deleted Item", Toast.LENGTH_SHORT).show()
                items.removeAt(position)
                this.notifyDataSetChanged()
            }*/

            val i = Intent(mCtx, Update::class.java)

            // below we are passing all our values.

            i.putExtra("name", mItem.Name)
            i.putExtra("age", mItem.Age)

            // starting our activity.

            mCtx.startActivity(i)
            true
        }


        val titleTextView: TextView = view.findViewById(R.id.textView1)
        val descriptionTextView: TextView = view.findViewById(R.id.textView2)

        //imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text = mItem.Name
        descriptionTextView.text = mItem.Age


        return view
    }
}