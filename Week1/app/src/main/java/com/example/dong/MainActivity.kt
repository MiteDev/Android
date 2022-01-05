package com.example.dong

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_recycler.view.*

class MainActivity : AppCompatActivity() {
    var imgRes = intArrayOf(
        R.drawable.cat, R.drawable.cat, R.drawable.cat
    )
    var exercise = arrayOf(
        "실내 걷기", "실외 걷기", "실외 걷기"
    )
    var dist = arrayOf(
        "0.85Km", "0.86Km", "3.21Km"
    )
    var date = arrayOf(
        "2022.01.04>", "2022.01.02>", "2022.01.01>"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = RecyclerAdapter()
        recycler1.adapter = adapter1

        recycler1.layoutManager = LinearLayoutManager(this)
    }

    inner class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val itemView = layoutInflater.inflate(R.layout.item_recycler, parent,false)
            val holder = ViewHolderClass(itemView)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.image.setImageResource(imgRes[position])
            holder.textExer.text = exercise[position]
            holder.textDist.text = dist[position]
            holder.textDate.text = date[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image = itemView.image
            val textExer = itemView.textExer
            val textDist = itemView.textDist
            val textDate = itemView.textDate
        }
    }
}