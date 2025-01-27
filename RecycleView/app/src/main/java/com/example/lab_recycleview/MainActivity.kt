package com.example.lab_recycleview

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList : ArrayList<DataClass>
    private lateinit var imageid : Array<Int>
    private lateinit var textId : Array<String>
    private lateinit var textBonkId : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageid = arrayOf(
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
            R.drawable.happy,
        )

        textId = resources.getStringArray(R.array.porodi_cat)
        textBonkId = resources.getStringArray(R.array.opisanie_cat)

        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newArrayList = arrayListOf<DataClass>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageid.indices) {
            val data = DataClass(imageid[i], textId[i], textBonkId[i])
            newArrayList.add(data)
        }
        newRecycleView.adapter = MyAdapter(newArrayList)
    }

    data class DataClass(var titleImage: Int, var heading: String, var bonktxt: String)

    class MyAdapter(private val newList : ArrayList<DataClass>):
            RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return newList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val curentItem = newList[position]
            holder.ImageView.setImageResource(curentItem.titleImage)
            holder.txtHead.text = curentItem.heading
            holder.txtBonk.text = curentItem.bonktxt

            holder.itemView.setOnClickListener {
                if (position == 0) {
                    Toast.makeText(holder.itemView.context, "Мы нажали на 1 элемент!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ImageView : ShapeableImageView = itemView.findViewById(R.id.imageItem)
            val txtHead : TextView = itemView.findViewById(R.id.txtItem)
            val txtBonk : TextView = itemView.findViewById(R.id.txtBonk)
        }
            }

}