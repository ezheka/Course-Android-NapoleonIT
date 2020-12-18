package com.efimcompany.myweather.feature.ScreenDays.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.feature.ScreenDays.presentation.ScreenDaysPresenter
import com.efimcompany.myweather.feature.ScreenDays.presentation.ScreenDaysView
import com.efimcompany.myweather.ui.WeatherDetailsFragment
import kotlinx.android.synthetic.main.fragment_weather7_day.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class Weather7DayFragment : MvpAppCompatFragment(R.layout.fragment_weather7_day), ScreenDaysView {

    private val presenter: ScreenDaysPresenter by moxyPresenter {
        ScreenDaysPresenter()
    }

    companion object {

        private const val WEATHERCITY = "WEATHERCITY"

        fun newInstance(weatherCity: String) =
            Weather7DayFragment().apply {
                arguments = Bundle().apply {
                    putString(WEATHERCITY, weatherCity)
                }
            }
    }

    private var  screenDaysAdapter: ScreenDaysAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            val weatherCity = it.getString(WEATHERCITY)

            textCity.text = "Погода в городе:\n$weatherCity"
        }

        with(rvDays){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ScreenDaysAdapter().also {
                screenDaysAdapter = it
            }
        }

    }

    override fun setWeather(weatherData: List<WeatherData>) {
        screenDaysAdapter?.setData(weatherData)
    }

    private fun openWeatherDetail(weatherData: WeatherData){
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherData))
            .addToBackStack("WeatherDetailsFragment")
            .commit()
    }
}

