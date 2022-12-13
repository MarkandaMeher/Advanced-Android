package com.example.cse226class

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast

class AsyncTaskExample : AppCompatActivity() {

    lateinit var pb : ProgressBar
    lateinit var lv : ListView
    var ar = arrayOf("1","2","3","4","5","6","7","8","9","10")
    lateinit var al : ArrayList<String?>
    lateinit var ad : ArrayAdapter<String?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        pb = findViewById<View>(R.id.pb) as ProgressBar
        lv = findViewById<View>(R.id.lv) as ListView
        al = ArrayList()
        ad = ArrayAdapter<String?>(this,android.R.layout.simple_list_item_1,al)
        lv.adapter=ad
        MyTask().execute()
    }

    @Suppress("DEPRECATION")
    internal inner class MyTask:
            AsyncTask<Void?, Int?, String>(){
                var count =0
        override fun onPreExecute() {
            super.onPreExecute()
            pb.max =10
            pb.progress=0
            pb.visibility = View.VISIBLE
            count =0
        }

        protected override fun doInBackground(vararg p0: Void?): String {
            for (i in 1..10){
                count = count +1
                publishProgress(i)
                try {
                    Thread.sleep(1000)
                }
                catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
            return "Completed"
        }

        protected override fun onProgressUpdate(vararg values: Int?) {
            //super.onProgressUpdate(*values)
            pb.progress = values[0]!!
            al.add(ar[count-1])
            ad.notifyDataSetChanged()
        }

        override fun onPostExecute(s: String?) {
            //Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
            pb.visibility = View.INVISIBLE
        }
            }
}