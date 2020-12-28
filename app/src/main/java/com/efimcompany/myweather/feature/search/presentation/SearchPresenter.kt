package com.efimcompany.myweather.feature.search.presentation

import android.content.SharedPreferences

class SearchPresenter(private val view: SearchView){

    private val sharedPreferences: SharedPreferences ?= null


    fun savingCoordinates(coordinates: String){
        val editor = sharedPreferences?.edit()
        editor?.putString("Coordinates", coordinates)
        editor?.apply()
    }

    fun validate(city: String, latitude: String, longitude: String): Boolean {

        return if(!nameCityIsCorrect(city) && !coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitude)){
            view.showAllError()
            false
        } else if ((coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitude))||
            (!coordinateLatitudeIsCorrect(latitude) && coordinateLongitubeIsCorrect(longitude))){
            view.showCoordinatesError()
            false
        } else true

    }


    private fun nameCityIsCorrect(nameCity: String): Boolean{
        return nameCity.isNotEmpty()

    }

    private  fun coordinateLatitudeIsCorrect(coordinateLatitude: String): Boolean{
        if (coordinateLatitude.isEmpty()) return false

        return try {
            val coordinatLat = coordinateLatitude.toDouble()
            coordinatLat in -90.0..90.0
        }

        catch (e:Exception){
            false
        }

    }

    private  fun coordinateLongitubeIsCorrect(coordinateLongitube: String): Boolean{
        if (coordinateLongitube.isEmpty()) return false

        return try {
            val coordinatLon = coordinateLongitube.toDouble()
            coordinatLon in -180.0..180.0
        }

        catch (e:Exception){
            false
        }

    }
}

interface SearchView {
    fun showNameCityError()

    fun showCoordinatesError()

    fun showAllError()

}