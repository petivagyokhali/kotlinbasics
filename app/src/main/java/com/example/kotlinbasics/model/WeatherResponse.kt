package com.example.kotlinbasics.model

data class WeatherResponse(
    val main:Main,
    val wind: Wind
)
data class Main(
    val temp: Float,
    val feels_like: Float,
    val humidity: Int
)
data class Wind(
    val speed: Float
)