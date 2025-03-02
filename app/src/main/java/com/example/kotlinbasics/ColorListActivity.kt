package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.ColorAdapter
import com.example.kotlinbasics.model.Color
import com.example.kotlinbasics.network.ColorService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ColorListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)

        val recyclerView: RecyclerView = findViewById(R.id.colorListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val colors = fetchColors()
                if (colors != null) {
                    recyclerView.adapter = ColorAdapter(colors)
                }
            } catch (e: Exception) {
                Log.e("ColorListActivity", "Error loading colors", e)
            }
        }
    }

    private suspend fun fetchColors(): List<Color>? {
        return try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val colorService = retrofit.create(ColorService::class.java)
            val response = colorService.getColors()
            response.data
        } catch (e: Exception) {
            Log.e("ColorListActivity", "Error fetching colors", e)
            null
        }
    }
}