package com.example.kotlinbasics.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.Color as ColorModel

class ColorAdapter(private val colorList: List<ColorModel>) :
    RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorName: TextView = itemView.findViewById(R.id.textview_color_name)
        val colorYear: TextView = itemView.findViewById(R.id.textview_color_year)
        val pantoneValue: TextView = itemView.findViewById(R.id.textview_pantone_value)
        val colorSample: View = itemView.findViewById(R.id.color_sample)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_color, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colorList[position]
        holder.colorName.text = color.name
        holder.colorYear.text = color.year.toString()
        holder.pantoneValue.text = color.pantone_value
        
        try {
            holder.colorSample.setBackgroundColor(Color.parseColor(color.color))
        } catch (e: Exception) {
            holder.colorSample.setBackgroundColor(Color.GRAY)
        }
    }

    override fun getItemCount() = colorList.size
}