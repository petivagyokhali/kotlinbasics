package com.example.kotlinbasics.model

data class ColorResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Color>
)

data class Color(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
)