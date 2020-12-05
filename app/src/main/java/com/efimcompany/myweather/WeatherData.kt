package com.efimcompany.myweather

import java.io.Serializable

data class WeatherData(val city:String, val date: String, val temp:Int, val temp_2:Int): Serializable
