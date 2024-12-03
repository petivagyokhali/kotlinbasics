package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {
    private lateinit var textviewTemp: TextView
    private lateinit var textview_feelsLike: TextView
    private val apiKey = "d62c8316648e688690fbaf18587ce8b0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        textviewTemp=findViewById(R.id.textView_temp)
        textview_feelsLike=findViewById(R.id.textView_feelsLike)
        fetchWeatherData()

    }


    private fun fetchWeatherData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService=retrofit.create(WeatherService::class.java)

        val call=weatherService.getWeather("Tatabánya", "metric", apiKey)
        call.enqueue(object:Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful){
                    val weatherResponse=response.body()
                    if(weatherResponse!=null){
                        val weatherInfo=weatherResponse.main.temp
                        textviewTemp.text=weatherInfo.toString()
                        val weatherInfo2=weatherResponse.main.feels_like
                        textview_feelsLike.text=weatherInfo2.toString()
                    }
                }
            }
            //hibakezeles
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("Hiba","Hiba az API kérés során.")
            }
        })

    }
}