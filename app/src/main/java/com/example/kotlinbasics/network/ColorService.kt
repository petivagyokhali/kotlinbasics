package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.ColorResponse
import retrofit2.http.GET

interface ColorService {
    @GET("/api/unknown")
    suspend fun getColors(): ColorResponse
}