package com.efimcompany.myweather.data

import android.content.SharedPreferences
import com.efimcompany.myweather.WeatherData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CachingWeatherImpl(
    private  val sharedPreferences: SharedPreferences
): CachingWeather {

    private var weathers: List<WeatherData>
        get() = sharedPreferences.getString(CACHING_WEATHER_KEY, null)?.let {
            try {
                Json.decodeFromString<List<WeatherData>>(it)
            } catch (t: Throwable) {
                emptyList<WeatherData>()
            }
        } ?: emptyList()
        set(value) {
            sharedPreferences.edit().putString(
                CACHING_WEATHER_KEY,
                Json.encodeToString(value)
            ).apply()
        }

    override fun add(weatherData: WeatherData) {
        weathers = weathers + weatherData
    }

    override fun delete(weatherData: WeatherData) {
        weathers = emptyList()
    }

    override fun getAll(): List<WeatherData> = weathers

    override fun isInCaching(weatherData: WeatherData): Boolean = weathers.contains(weatherData)

    companion object {
        private const val CACHING_WEATHER_KEY = "CACHING_WEATHER_KEY"
    }
}