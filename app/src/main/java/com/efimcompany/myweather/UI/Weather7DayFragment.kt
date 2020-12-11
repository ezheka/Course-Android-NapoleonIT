package com.efimcompany.myweather.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.efimcompany.myweather.R
import com.efimcompany.myweather.WeatherData
import kotlinx.android.synthetic.main.fragment_weather7_day.*

class Weather7DayFragment : Fragment(R.layout.fragment_weather7_day) {

    companion object {

        private const val WEATHERCITY = "WEATHERCITY"

        fun newInstance(weatherCity: String) =
            Weather7DayFragment().apply {
                arguments = Bundle().apply {
                    putString(WEATHERCITY, weatherCity)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherday_1 = WeatherData("11.12.2020", -11,-21)
        val weatherday_2 = WeatherData("12.12.2020", -12,-22)
        val weatherday_3 = WeatherData("13.12.2020", -13,-23)
        val weatherday_4 = WeatherData("14.12.2020", -14,-24)
        val weatherday_5 = WeatherData("15.12.2020", -15,-25)
        val weatherday_6 = WeatherData("16.12.2020", -16,-26)
        val weatherday_7 = WeatherData("17.12.2020", -17,-27)

        arguments?.let{
            val weatherCity = it.getString(WEATHERCITY)

            textCity.text = "Погода в городе:\n$weatherCity"
        }

        buttonDay1.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_1))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay2.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_2))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay3.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_3))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay4.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_4))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay5.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_5))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay6.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_6))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        buttonDay7.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weatherday_7))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
    }
}