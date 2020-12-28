package com.efimcompany.myweather.domain

import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.di.WeatherApi

class GetWeatherUseCase(private val weatherApi: WeatherApi, private val lat: Double, private val lon: Double) {

    suspend operator fun invoke(): List<WeatherData>{
        val response =  weatherApi.getWeatherDays(lat, lon)
        return response.run {
            forecasts?.mapNotNull { forecast ->
                WeatherData(
                    cityName = geoObject?.locality?.name ?:return@mapNotNull null,
                    date = forecast.date ?: return@mapNotNull null,
                    temp = forecast.parts?.dayShort?.temp ?: return@mapNotNull null,
                    feels_like = forecast.parts?.dayShort?.feelsLike ?: return@mapNotNull null,
                    condition = forecast.parts?.dayShort?.condition ?: return@mapNotNull null,
                    wind_speed = forecast.parts?.dayShort?.windSpeed ?: return@mapNotNull null,
                    wind_gust = forecast.parts?.dayShort?.windGust ?: return@mapNotNull null,
                    wind_dir = forecast.parts?.dayShort?.windDir ?: return@mapNotNull null,
                    pressure_mm = forecast.parts?.dayShort?.pressureMm ?: return@mapNotNull null,
                    humidity = forecast.parts?.dayShort?.humidity ?: return@mapNotNull null,
                )
            } ?: emptyList()
        }
    }
}