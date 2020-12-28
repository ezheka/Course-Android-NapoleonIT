package com.efimcompany.myweather.feature.screenDays.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.di.weatherApi
import com.efimcompany.myweather.domain.GetWeatherUseCase
import com.efimcompany.myweather.feature.detail.ui.WeatherDetailsFragment
import com.efimcompany.myweather.feature.screenDays.presentation.ScreenDaysPresenter
import com.efimcompany.myweather.feature.screenDays.presentation.ScreenDaysView
import com.efimcompany.myweather.ui.StartFragment
import kotlinx.android.synthetic.main.fragment_weather7_day.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class Weather7DayFragment : MvpAppCompatFragment(R.layout.fragment_weather7_day), ScreenDaysView {

    private var lat: Double = 55.753215
    private var lon: Double = 37.622504
    private var cityName: String = ""

    private val presenter: ScreenDaysPresenter by moxyPresenter {
        arguments?.let{

            val coordinat = it.getString(WEATHERCOORDINATS)!!.split(" ")

            lon = coordinat[0].toDouble()
            lat = coordinat[1].toDouble()

        }
        ScreenDaysPresenter(GetWeatherUseCase(weatherApi, lat, lon))
    }

    companion object {

        private const val WEATHERCOORDINATS = "WEATHERCOORDINATS"

        fun newInstance(coordinates: String) =
            Weather7DayFragment().apply {
                arguments = Bundle().apply {

                    putString(WEATHERCOORDINATS, coordinates)

                }
            }
    }

    private var  screenDaysAdapter: ScreenDaysAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_cityName.text = cityName

        with(rvDays){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ScreenDaysAdapter(onDayClick = {
                presenter.onDayClick(it)
            }).also {
                screenDaysAdapter = it
            }
        }

        tv_cityName.setOnClickListener{
            openStartFragment(false)
        }

    }

    override fun showWeather(weatherData: List<WeatherData>) {
        tv_cityName.text = weatherData[0].cityName
        screenDaysAdapter?.submitList(weatherData)
    }

    override fun openWeatherDetail(weatherData: WeatherData){
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherData))
            .addToBackStack("WeatherDetailsFragment")
            .commit()
    }

    override fun showLoading(isShow: Boolean) {
        weatherProgress.isVisible = isShow
    }

    override fun openStartFragment(isError: Boolean) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container,
                StartFragment())
            .addToBackStack("StartFragment")
            .commit()

        if(isError) Toast.makeText(requireContext(), "Координаты не найдены", Toast.LENGTH_LONG).show()
        else Toast.makeText(requireContext(), "Координаты сброшены", Toast.LENGTH_LONG).show()
    }
}

