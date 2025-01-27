package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn : Button = findViewById(R.id.btnChoose)
        val tvChos : TextView = findViewById(R.id.tvChoose)
        val imageChos : ImageView = findViewById(R.id.imChoose)

        btn.setOnClickListener {
            if (binding.cbCar.isChecked) {
                tvChos.text = binding.cbCar.text
                imageChos.visibility = android.view.View.VISIBLE
                imageChos.setImageResource(R.drawable.car)
            } else if (binding.cbBus.isChecked) {
                tvChos.text = binding.cbBus.text
                imageChos.visibility = android.view.View.VISIBLE
                imageChos.setImageResource(R.drawable.bus)
            } else if (binding.cbTraktor.isChecked) {
                tvChos.text = binding.cbTraktor.text
                imageChos.visibility = android.view.View.VISIBLE
                imageChos.setImageResource(R.drawable.traktor)
            } else {
                tvChos.text = "Вы ничего не выбрали"
                imageChos.visibility = android.view.View.INVISIBLE
            }
        }
    }
}