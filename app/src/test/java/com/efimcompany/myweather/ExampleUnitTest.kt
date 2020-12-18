package com.efimcompany.myweather
/*
import com.google.gson.Gson
import khttp.get
 */
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */



fun TestGetKhttp(){
/*
    val resp = get(
        url = "https://geocode-maps.yandex.ru/1.x/",
        params = mapOf("format" to "json", "apikey" to "c89e8a63-acf8-42f3-b555-d396295960e8", "geocode" to "челяб")
    )

    //println(resp.text)

    val geoAPIYandex = Gson().fromJson(resp.text, GeoAPIYandex::class.java)

    val geocity = writeCityName(geoAPIYandex.response.GeoObjectCollection.featureMember[0].GeoObject.metaDataProperty.GeocoderMetaData.Address.Components)
    val geopos = geoAPIYandex.response.GeoObjectCollection.featureMember[0].GeoObject.Point.pos

    val geoPosPars = geopos.split(" ")

    val lon = geoPosPars[0]
    val lat = geoPosPars[1]


    println("$geocity ( широта:$lat, долгота: $lon)")

    val response = get(
        url = "https://api.weather.yandex.ru/v2/forecast",
        headers = mapOf("X-Yandex-API-Key" to "01cee637-437f-4881-9fa4-aab0bf846391"),
        params = mapOf("lat" to lat, "lon" to lon, "lang" to "ru_RU")
    )

    val jsonYandexAPI = Gson().fromJson(response.text, JsonYandexAPI::class.java)

    for (i in 0..6){

        var date = LocalDate.parse(jsonYandexAPI.forecasts[i].date)
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        var formattedDate = date.format(formatter)

        println(formattedDate +
                " - Темпиратура воздуха: "+ jsonYandexAPI.forecasts[i].parts.day_short.temp+
                "* ощущается как: "+ jsonYandexAPI.forecasts[i].parts.day_short.feels_like+
                "* | "+ descriptionWeather(jsonYandexAPI.forecasts[i].parts.day_short.condition)+
                " | Скорость ветра: "+ jsonYandexAPI.forecasts[i].parts.day_short.wind_speed+
                " порывы до: "+ jsonYandexAPI.forecasts[i].parts.day_short.wind_gust+
                " направление ветра: "+ windDirection(jsonYandexAPI.forecasts[i].parts.day_short.wind_dir)+
                " | Давление: "+ jsonYandexAPI.forecasts[i].parts.day_short.pressure_mm+" мм рт.ст"+
                " | Влажность воздуха: "+ jsonYandexAPI.forecasts[i].parts.day_short.humidity+"%")
    }

 */

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
        println("\n\n\nПогода по координатам: ")
        TestGetKhttp()

    }

    fun List<DataSchoolClasses>.sortingByClass(): List<DataSchoolClasses>{
        return  this.sortedBy { it.classNumber }
    }

    fun List<DataSchoolClasses>.sortingByAge(): List<DataSchoolClasses>{
        return  this.sortedBy { it.age }
    }
}