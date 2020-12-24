package com.efimcompany.myweather.di

import com.efimcompany.myweather.data.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v2/forecast")
    suspend fun getWeatherDays(
        @Query("lat") lat:Double = 55.753215,
        @Query("lot") lot:Double = 37.622504,
        @Query("lang") lang:String = "ru_RU"
    ): WeatherResponse
}