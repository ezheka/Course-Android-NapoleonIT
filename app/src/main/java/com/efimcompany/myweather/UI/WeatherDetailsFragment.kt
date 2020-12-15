package com.efimcompany.myweather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import kotlinx.android.synthetic.main.fragment_weather_details.*

class WeatherDetailsFragment : Fragment(R.layout.fragment_weather_details) {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weatherData: WeatherData) =
            WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER, weatherData)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            val weatherData = it.getParcelable<WeatherData>(WEATHER)

            textHeaderDetalis.text = "Погода на\n${weatherData?.date}"
            textWeather.text = "${weatherData?.temp}"
            textWeather_2.text = "Ощущается как: ${weatherData?.temp_2}"
        }
    }
}