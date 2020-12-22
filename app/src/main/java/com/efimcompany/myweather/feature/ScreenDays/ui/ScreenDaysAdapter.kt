package com.efimcompany.myweather.feature.screenDays.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.weather_item.*

class ScreenDaysAdapter(private val onDayClick: (WeatherData) -> Unit) :
    ListAdapter<WeatherData, ScreenDaysAdapter.ViewHolder>(WeatherDataFillUtilityBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.weatherDaysDay.text = item.date
        holder.weatherDaysTemp.text = "${item.temp} ощущается как: ${item.temp_2}"
        holder.containerView.setOnClickListener{
            onDayClick(item)
        }
    }

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView),
        LayoutContainer

}

class WeatherDataFillUtilityBack: DiffUtil.ItemCallback<WeatherData>() {
    override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem == newItem
    }

}