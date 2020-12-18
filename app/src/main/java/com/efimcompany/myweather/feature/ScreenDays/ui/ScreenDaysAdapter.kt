package com.efimcompany.myweather.feature.ScreenDays.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.weather_item.*

class ScreenDaysAdapter : RecyclerView.Adapter<ScreenDaysAdapter.ViewHolder>(){

    private  var weatherDays: MutableList<WeatherData> = mutableListOf()

    fun setData(weatherDays: List<WeatherData>){
        this.weatherDays.clear()
        this.weatherDays.addAll(weatherDays)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return   ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weatherDays[position]
        holder.weatherDaysDay.text = item.date
        holder.weatherDaysDay.text = "${item.temp} ощущается как: ${item.temp_2}"
    }

    override fun getItemCount(): Int = weatherDays.size

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView), LayoutContainer

}