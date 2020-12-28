package com.efimcompany.myweather.di

import com.efimcompany.myweather.data.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi{

    @GET("v2/forecast")
    suspend fun getWeatherDays(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double
    ): WeatherResponse
}