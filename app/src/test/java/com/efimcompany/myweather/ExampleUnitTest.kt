package com.efimcompany.myweather

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

data class DataSchoolClasses(val name:String, val age:Int, val classNumber:Int) {
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
    }

    fun List<DataSchoolClasses>.sortingByClass(): List<DataSchoolClasses>{
        return  this.sortedBy { it.classNumber }
    }

    fun List<DataSchoolClasses>.sortingByAge(): List<DataSchoolClasses>{
        return  this.sortedBy { it.age }
    }

    @Test
    fun coroutinesTest(){
        runBlocking {
            launch {

            }
        }
    }
}