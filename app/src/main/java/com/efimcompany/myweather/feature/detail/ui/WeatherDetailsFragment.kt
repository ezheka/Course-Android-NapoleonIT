package com.efimcompany.myweather.feature.detail.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html.fromHtml
import android.view.View
import androidx.annotation.RequiresApi
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.data.CachingWeatherImpl
import com.efimcompany.myweather.decryptionCondition
import com.efimcompany.myweather.decryptionWindDir
import com.efimcompany.myweather.feature.detail.presentation.WeatherDetailPresenter
import com.efimcompany.myweather.feature.detail.presentation.WeatherDetailView
import kotlinx.android.synthetic.main.fragment_weather_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class WeatherDetailsFragment : MvpAppCompatFragment(R.layout.fragment_weather_details),
    WeatherDetailView {

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun setCaching(weatherData: WeatherData) {

        val date = LocalDate.parse(weatherData.date)

        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        val formattedDate = date.format(formatter)

        Locale.CHINA

        tv_Date.text = "Погода на\n$formattedDate"
        tv_temp.text = "${weatherData?.temp}°"

        tv_feelsLike.text = fromHtml("ощущается как: ${
            changingTheColor("${weatherData.feels_like}°",
                "#41081c")
        }",0)

        tv_condition.text = decryptionCondition(weatherData.condition)

        tv_wind.text = fromHtml("Скорость ветра: ${
            changingTheColor("${weatherData.wind_speed}м/с",
                "#41081c")
        }<br>" +
                "порывы до: ${changingTheColor("${weatherData.wind_gust}м/с", "#41081c")}<br>" +
                "направление ветра: ${
                    changingTheColor(decryptionWindDir(weatherData.wind_dir),
                        "#41081c")
                }",0)

        tv_humidity.text = fromHtml("Влажность:<br>${
            changingTheColor("${weatherData.humidity}%",
                "#41081c")
        }",0)

        tv_pressure.text = fromHtml("Атмосферное<br>давление:<br>${
            changingTheColor("${weatherData.pressure_mm}мм рт.ст.",
                "#41081c")
        }",0)
    }

    override fun setIsInCaching(inCaching: Boolean) {
        cechingDetailImg.setImageResource(
            if (inCaching) R.drawable.ic_baseline_sync_24
            else R.drawable.ic_baseline_sync_disabled_24
        )
    }

    /**
     * Изменение цвета строки str
     */
    fun changingTheColor(str: String, color: String): String{
        return "<font color='$color'>$str</font>"
    }
}