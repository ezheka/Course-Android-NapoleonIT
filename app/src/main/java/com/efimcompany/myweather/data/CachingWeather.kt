package com.efimcompany.myweather.data

import com.efimcompany.myweather.WeatherData

interface CachingWeather {

    /**
     * Функция добавления [weatherData] в кэш
     * */
    fun add(weatherData: WeatherData)

    /**
     * Функция удаления [weatherData] из кэша
     * */
    fun delete(weatherData: WeatherData)

    /**
     * @return кэшированныю погоду
     * может быть пустым
     * */
    fun getAll(): List<WeatherData>

    /**
     * @return true если погода закеширована, иначе false
     * */
    fun isInCaching(weatherData: WeatherData): Boolean

}

