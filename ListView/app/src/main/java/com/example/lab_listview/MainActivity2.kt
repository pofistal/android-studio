package com.example.lab_listview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        data class ListItem(val imageR: Int, val text: String, val action: String){

        }

        class AdapterList(context: Context, private val items: List<ListItem>) : ArrayAdapter<ListItem>(context, 0 ,items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val item = getItem(position)

                val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

                val imageView : ImageView = view.findViewById(R.id.ImageView)
                val textView : TextView = view.findViewById(R.id.tvList)

                item?.let {
                    imageView.setImageResource(it.imageR)
                    textView.text = it.text
                }
                return view
            }
        }

        val items = listOf(
            ListItem(R.drawable.happy, "Takata - New Faces", "Action1"),
            ListItem(R.drawable.happy, "Takata - Soothing Rhythm", "Action1"),
            ListItem(R.drawable.happy, "Takata - Rio Rhythm", "Action1"),
            ListItem(R.drawable.happy, "Takata - Pure Waves", "Action1"),
            ListItem(R.drawable.happy, "Takata - Gentle Rainfall", "Action1"),
            ListItem(R.drawable.happy, "Takata - Sunrise Waves", "Action1"),
            ListItem(R.drawable.happy, "Takata - Falling Leaves", "Action1"),
            ListItem(R.drawable.happy, "Takata - Heart of Bossa", "Action1"),
            ListItem(R.drawable.happy, "Takata - Soothing Sunlight", "Action1"),
            ListItem(R.drawable.happy, "Takata - Glow Up", "Action1"),
            ListItem(R.drawable.happy, "Takata - Glow Bright", "Action1"),
            ListItem(R.drawable.happy, "Takata - Rio Nights", "Action1"),
        )

        val listView : ListView = findViewById(R.id.lvMain)

        val adapter = AdapterList(this, items)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = items[position]
            when(selectedItem.action) {
                "Action1" -> {
                    Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}