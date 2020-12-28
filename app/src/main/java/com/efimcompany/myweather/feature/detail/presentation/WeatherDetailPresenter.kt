package com.efimcompany.myweather.feature.detail.presentation

import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.data.CachingWeather
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class WeatherDetailPresenter(
    private val weatherData: WeatherData,
    private val cachingWeather: CachingWeather
): MvpPresenter<WeatherDetailView>(){

    private var isInCaching: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCaching(weatherData)

        isInCaching = cachingWeather.isInCaching(weatherData)
        viewState.setIsInCaching(isInCaching)
    }

    fun onCaching(){
        if(isInCaching){
            cachingWeather.delete(weatherData)
        } else{
            cachingWeather.add(weatherData)
        }
        isInCaching = !isInCaching
        viewState.setIsInCaching(isInCaching)
    }

}

interface WeatherDetailView: MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCaching(weatherData: WeatherData)


    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setIsInCaching(inCaching: Boolean)

}