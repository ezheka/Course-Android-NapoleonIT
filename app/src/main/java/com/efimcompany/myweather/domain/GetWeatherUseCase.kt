package com.efimcompany.myweather.domain

import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.di.WeatherApi

class GetWeatherUseCase(private val weatherApi: WeatherApi) {

    suspend operator fun invoke(): List<WeatherData>{
        val response =  weatherApi.getWeatherDays()
        response.run {
            forecasts?.map { forecast ->
                WeatherData(

                )
            }
        }
    }
}
