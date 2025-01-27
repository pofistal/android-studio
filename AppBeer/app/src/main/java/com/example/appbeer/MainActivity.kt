package com.example.appbeer

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var spinBeer: Spinner
    private lateinit var btnBeer: Button
    private lateinit var tvBeer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinBeer = findViewById(R.id.spinBeer)
        btnBeer = findViewById(R.id.btnBeer)
        tvBeer = findViewById(R.id.tvBeer)

        btnBeer.setOnClickListener {
            val selectedBeerType = spinBeer.selectedItem.toString()
            val beers = getBeers(selectedBeerType)
            val resultText = if (beers.isNotEmpty()) {
                "Рекомендуемые сорта: ${beers.joinToString(", ")}"
            } else {
                "Нет доступных сортов."
            }
            tvBeer.text = resultText
        }
    }

    private fun getBeers(selectedBeerType: String): List<String> {
        return when (selectedBeerType) {
            "Тёмное" -> listOf("Балтика №9", "Старый Мельник", "Сибирская Корона Темная")
            "Светлое" -> listOf("Балтика №3", "Жигули", "Очаково")
            "Сладкое" -> listOf("Жигули Барное Темное", "Вельвет")
            "Горькое" -> listOf("Балтика №7", "Золотая бочка", "AF Brew")
            "Я не пью" -> listOf("Вода", "Добрый Кола")
            else -> emptyList()
        }
    }
}