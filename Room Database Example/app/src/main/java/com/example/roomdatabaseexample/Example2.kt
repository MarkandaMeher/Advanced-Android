package com.example.roomdatabaseexample

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Example2 : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example2)

        database = Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contactDB").build()


        listView = findViewById<ListView>(R.id.listview)

        val adapter = MyAdapter(this,R.layout.listitem, mutableListOf())
        listView.adapter=adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val view = parent[position]
            val id = view.findViewById<TextView>(R.id.idListItem).text.toString().toLong()
            val name = view.findViewById<TextView>(R.id.nameListItem).text.toString()
            val phone = view.findViewById<TextView>(R.id.phoneListItem).text.toString().toLong()

            var builder = AlertDialog.Builder(this)
            builder.setTitle("Edit")
            var linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.VERTICAL

            val idView = EditText(this)
            idView.setText(id.toString())
            linearLayout.addView(idView)

            val nameView = EditText(this)
            nameView.text.clear()
            nameView.setText(name)
            linearLayout.addView(nameView)

            val phoneView = EditText(this)
            phoneView.text.clear()
            phoneView.setText(phone.toString())
            linearLayout.addView(phoneView)

            builder.setView(linearLayout)
            builder.setPositiveButton("Update") { dialog, _ ->
                val name = nameView.text.toString()
                val phone = phoneView.text.toString().toLong()
                GlobalScope.launch(Dispatchers.IO) {
                    database.contactDAO().updateContact(Contact(id, name, phone))
                }
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancel") { it, _ -> it.dismiss() }

            builder.create().show()
        }


        findViewById<FloatingActionButton>(R.id.floatingbtn).setOnClickListener {
            val builder = android.app.AlertDialog.Builder(this)
            builder.setTitle("Insert Contact")
            val etName = EditText(this)
            val etPhone = EditText(this)
            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.VERTICAL
            layout.addView(etName)
            layout.addView(etPhone)
            builder.setView(layout)
            builder.setPositiveButton("Insert") { dialog, _ ->
                val name = etName.text.toString()
                val phone = etPhone.text.toString().toLong()
                GlobalScope.launch(Dispatchers.IO) {
                    database.contactDAO().insertContact(Contact(0,name, phone))
                }
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancel") { it, _ -> it.dismiss() }
            builder.create().show()
        }

        database.contactDAO().getContact().observe(this) {
            adapter.clear()
            adapter.addAll(it)
        }

    }
}
