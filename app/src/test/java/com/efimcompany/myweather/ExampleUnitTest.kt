package com.efimcompany.myweather

import khttp.responses.Response
import khttp.delete as httpDelete
import org.junit.Test
import org.json.JSONObject
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

fun TestGetKhttp(){

    val response = khttp.get(
        url = "https://api.weather.yandex.ru/v2/forecast",
        headers = mapOf("X-Yandex-API-Key" to "01cee637-437f-4881-9fa4-aab0bf846391"),
        params = mapOf("lat" to "55", "lon" to "61", "lang" to "ru_RU")
    )

    print(response.text)

}

class ExampleUnitTest {

    val schoolboy_1 = DataSchoolClasses("Ivan", 8,2)
    val schoolboy_2 = DataSchoolClasses("Mary", 10,4)
    val schoolboy_3 = DataSchoolClasses("Mark", 14,8)
    val schoolboy_4 = DataSchoolClasses("Elena", 15,9)
    val schoolboy_5 = DataSchoolClasses("Den", 7,1)

    val collection = listOf(schoolboy_1,schoolboy_2,schoolboy_3,schoolboy_4,schoolboy_5)

    @Test
    fun addition_isCorrect() {
        // Тест яндекс погода api
        // TestGetKhttp()

        print(collection.sortingByClass())
        print(collection.sortingByAge())
    }

    fun List<DataSchoolClasses>.sortingByClass(): List<DataSchoolClasses>{
        return  this.sortedBy { it.classNumber }
    }

    fun List<DataSchoolClasses>.sortingByAge(): List<DataSchoolClasses>{
        return  this.sortedBy { it.age }
    }
}