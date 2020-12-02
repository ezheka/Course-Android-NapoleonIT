package com.efimcompany.myweather

import androidx.core.graphics.toColorInt
import com.google.gson.Gson
import khttp.get
import khttp.responses.Response
import khttp.delete as httpDelete
import org.junit.Test
import org.json.JSONObject
import org.junit.Assert.*
import java.time.LocalDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */



fun TestGetKhttp(){

    val response = get(
        url = "https://api.weather.yandex.ru/v2/forecast",
        headers = mapOf("X-Yandex-API-Key" to "01cee637-437f-4881-9fa4-aab0bf846391"),
        params = mapOf("lat" to "55", "lon" to "61", "lang" to "ru_RU")
    )

    val jsonYandexAPI = Gson().fromJson(response.text, JsonYandexAPI::class.java)

    for (i in 0..6){
        println(LocalDate.parse(jsonYandexAPI.forecasts[i].date).dayOfMonth.toString() + " " + LocalDate.parse(jsonYandexAPI.forecasts[i].date).month +
                " - Темпиратура воздуха: "+ jsonYandexAPI.forecasts[i].parts.day_short.temp+
                "* ощущается как: "+ jsonYandexAPI.forecasts[i].parts.day_short.feels_like+
                "* | "+ descriptionWeather(jsonYandexAPI.forecasts[i].parts.day_short.condition)+
                " | Скорость ветра: "+ jsonYandexAPI.forecasts[i].parts.day_short.wind_speed+
                " порывы до: "+ jsonYandexAPI.forecasts[i].parts.day_short.wind_gust+
                " направление ветра: "+ windDirection(jsonYandexAPI.forecasts[i].parts.day_short.wind_dir)+
                " | Давление: "+ jsonYandexAPI.forecasts[i].parts.day_short.pressure_mm+" мм рт.ст"+
                " | Влажность воздуха: "+ jsonYandexAPI.forecasts[i].parts.day_short.humidity+"%")
    }

}

class ExampleUnitTest {

    val schoolboy_1 = DataSchoolClasses("Elena", 15,1)
    val schoolboy_2 = DataSchoolClasses("Mary", 10,4)
    val schoolboy_3 = DataSchoolClasses("Den", 7,8)
    val schoolboy_4 = DataSchoolClasses("Ivan", 8,2)
    val schoolboy_5 = DataSchoolClasses("Mark", 14,3)

    val collection = listOf(schoolboy_1,schoolboy_2,schoolboy_3,schoolboy_4,schoolboy_5)

    @Test
    fun startTest() {

        println("Домашняя работа 1")
        println(collection.sortingByClass())
        println(collection.sortingByAge())

        // Тест яндекс погода api
        println("\n\n\nПогода")
        TestGetKhttp()

    }

    fun List<DataSchoolClasses>.sortingByClass(): List<DataSchoolClasses>{
        return  this.sortedBy { it.classNumber }
    }

    fun List<DataSchoolClasses>.sortingByAge(): List<DataSchoolClasses>{
        return  this.sortedBy { it.age }
    }
}