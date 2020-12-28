package com.efimcompany.myweather.feature.search.presentation

import android.content.SharedPreferences
import android.util.Log
import com.efimcompany.myweather.domain.GetGeoUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenterScope
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class SearchPresenter(): MvpPresenter<SearchView>() {

    private val sharedPreferences: SharedPreferences ?= null

    fun onSearchCity(getGoeUseCase: GetGeoUseCase) {
        viewState.showLoading(isShow = true)
        presenterScope.launch(CoroutineExceptionHandler { context, throwable ->
            viewState.showLoading(isShow = false)
            Log.e("tag", throwable.message, throwable)
            viewState.showNameCityError()
        }) {
            val geoData = getGoeUseCase()
            viewState.showLoading(isShow = false)
            viewState.openWeatherDaysFragment(geoData[0].coordinates)
        }
    }

    fun savingCoordinates(coordinates: String){
        val editor = sharedPreferences?.edit()
        editor?.putString("Coordinates", coordinates)
        editor?.apply()
    }

    fun validate(city: String, latitude: String, longitude: String): Boolean {

        return if(!nameCityIsCorrect(city) && !coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitude)){
            viewState.showAllError()
            false
        } else if ((coordinateLatitudeIsCorrect(latitude) && !coordinateLongitubeIsCorrect(longitude))||
            (!coordinateLatitudeIsCorrect(latitude) && coordinateLongitubeIsCorrect(longitude))){
            viewState.showCoordinatesError()
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

interface SearchView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showNameCityError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCoordinatesError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showAllError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDaysFragment(coordinates: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(isShow: Boolean)
}