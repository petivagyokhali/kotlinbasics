package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService{
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") cityName:String,
        @Query("units") units:String,
        @Query("appid") apiKey:String
    ): Call<WeatherResponse>
}