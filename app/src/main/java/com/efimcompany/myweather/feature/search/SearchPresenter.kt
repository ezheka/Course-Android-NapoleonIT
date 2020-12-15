package com.efimcompany.myweather.feature.search

import com.efimcompany.myweather.ui.CityAndCoordinates

class SearchPresenter(private val view: SearchView) {

    var cityAndCoordinates = CityAndCoordinates("Челябинск", 55.15402,61.42915)

    fun setData(cityAndCoordinates: CityAndCoordinates) {
        this.cityAndCoordinates=cityAndCoordinates
    }

    fun validate(city: String, latitude: String, longitube: String): Boolean {

        if(!nameCityIsCorrect(city) && !coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitube)){

            view.showAllError()
            return false
        }
        else if ((coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitube))||
            (!coordinateLatitudeIsCorrect(latitude) && coordinateLongitubeIsCorrect(longitube))){
            view.showCoordinatesError()
            return false
        }
        else return true

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
            val coordinatLot = coordinateLongitube.toDouble()
            coordinatLot in -180.0..180.0
        }

        catch (e:Exception){
            false
        }

    }
}