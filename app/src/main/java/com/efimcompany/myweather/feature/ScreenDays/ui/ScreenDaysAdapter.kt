package com.efimcompany.myweather.feature.screenDays.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.decryptionCondition
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.weather_item.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ScreenDaysAdapter(private val onDayClick: (WeatherData) -> Unit) :
    ListAdapter<WeatherData, ScreenDaysAdapter.ViewHolder>(WeatherDataFillUtilityBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        val date = LocalDate.parse(item.date)
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        val formattedDate = date.format(formatter)

        holder.tv_Date.text = formattedDate
        holder.tv_condition.text = decryptionCondition(item.condition)
        holder.tv_temp.text = "${item.temp}°"
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