package com.efimcompany.myweather.feature.screenDays.presentation

import android.util.Log
import com.efimcompany.myweather.WeatherData
import com.efimcompany.myweather.domain.GetWeatherUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenterScope
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class ScreenDaysPresenter(
    private val getWeatherUseCase: GetWeatherUseCase
): MvpPresenter<ScreenDaysView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading(isShow = true)
        presenterScope.launch(CoroutineExceptionHandler { context, throwable ->
            viewState.showLoading(isShow = false)
            Log.e("tag", throwable.message, throwable)
            viewState.openStartFragment(true)
        }) {

            val weatherData = getWeatherUseCase()
            viewState.showWeather(weatherData)
            viewState.showLoading(isShow = false)
        }
    }

    fun onDayClick(weatherData: WeatherData) {
        viewState.openWeatherDetail(weatherData)
    }
}

interface ScreenDaysView: MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showWeather(weatherData: List<WeatherData>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openWeatherDetail(weatherData: WeatherData)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(isShow: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openStartFragment(isError: Boolean)

}
