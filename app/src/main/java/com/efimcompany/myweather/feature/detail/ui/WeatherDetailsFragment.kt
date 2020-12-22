package com.efimcompany.myweather.feature.detail.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.data.CachingWeatherImpl
import com.efimcompany.myweather.feature.detail.presentation.WeatherDetailPresenter
import com.efimcompany.myweather.feature.detail.presentation.WeatherDetailView
import kotlinx.android.synthetic.main.fragment_weather_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class WeatherDetailsFragment : MvpAppCompatFragment(R.layout.fragment_weather_details), WeatherDetailView {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weatherData: WeatherData) =
            WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER, weatherData)
                }
            }
    }

    private val presenter: WeatherDetailPresenter by moxyPresenter {
        WeatherDetailPresenter(
            weatherData = arguments?.getParcelable(WEATHER)!!,
            cachingWeather = CachingWeatherImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cechingDetailImg.setOnClickListener {
            presenter.onCaching()
        }
    }

    override fun setCaching(weatherData: WeatherData) {
        textHeaderDetalis.text = "Погода на\n${weatherData?.date}"
        textWeather.text = "${weatherData?.temp}"
        textWeather_2.text = "Ощущается как: ${weatherData?.temp_2}"
    }

    override fun setIsInCaching(inCaching: Boolean) {
        cechingDetailImg.setImageResource(
            if(inCaching) R.drawable.ic_baseline_sync_24
            else R.drawable.ic_baseline_sync_disabled_24
        )
    }


}