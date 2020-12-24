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

    /*private var weatherdays: List<WeatherData> = listOf(
        WeatherData("11.12.2020", -11,-21),
        WeatherData("12.12.2020", -12,-22),
        WeatherData("13.12.2020", -13,-23),
        WeatherData("14.12.2020", -14,-24),
        WeatherData("15.12.2020", -15,-25),
        WeatherData("16.12.2020", -16,-26),
        WeatherData("17.12.2020", -17,-27)
    )

     */

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading(isShow = true)
        presenterScope.launch(CoroutineExceptionHandler { context, throwable ->
            viewState.showLoading(isShow = false)
            Log.e("tag", throwable.message, throwable)
        }) {

            val weatherData: List<WeatherData> = getWeatherUseCase()
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

}
