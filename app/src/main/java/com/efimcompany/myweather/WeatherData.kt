package com.efimcompany.myweather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class WeatherData(val cityName:String,
                       val date: String,
                       val temp: Int, val feels_like: Int,
                       val condition: String,
                       val wind_speed: Double, val wind_gust: Double, val wind_dir: String,
                       val pressure_mm: Int, val humidity: Int): Parcelable
/**
 * date - Дата
 * temp - Температура
 * feels_like - Ощущаемая температура
 * condition - Код расшифровки погодного описания
 * wind_speed - Скорость ветра
 * wind_gust - Скорость порывов ветра
 * wind_dir - Направление ветра
 * pressure_mm - Давление
 * humidity - Влажность воздуха
 * */

fun decryptionCondition(str:String): String {
    var descript: String = ""
    when (str){
        "clear" -> descript = "Ясно"
        "partly-cloudy" -> descript = "Малооблачно"
        "cloudy" -> descript = "Облачно с прояснениями"
        "overcast" -> descript = "Пасмурно"
        "drizzle" -> descript = "Морось"
        "light-rain" -> descript = "Небольшой дождь"
        "rain" -> descript = "Дождь"
        "moderate-rain" -> descript = "Умеренно сильный дождь"
        "heavy-rain" -> descript = "Сильный дождь"
        "continuous-heavy-rain" -> descript = "Длительный сильный дождь"
        "showers" -> descript = "Ливень"
        "wet-snow" -> descript = "Дождь со снегом"
        "light-snow" -> descript = "Небольшой снег"
        "snow" -> descript = "Снег"
        "snow-showers" -> descript = "Снегопад"
        "hail" -> descript = "Град"
        "thunderstorm" -> descript = "Гроза"
        "thunderstorm-with-rain" -> descript = "Дождь с грозой"
        "thunderstorm-with-hail" -> descript = "Гроза с градом"
    }

    return descript
}

fun decryptionWindDir(str:String): String {
    var wind = ""
    when(str){
        "nw" -> wind = " С-З"
        "n" -> wind = "С"
        "ne" -> wind = "С-В"
        "e" -> wind = "В"
        "se" -> wind = "Ю-В"
        "s" -> wind = "Ю"
        "sw" -> wind = "Ю-З"
        "w" -> wind = "З"
        "с" -> wind = "Штиль"
    }

    return wind
}

@Parcelize
@Serializable
data class GeoData(val coordinates: String): Parcelable