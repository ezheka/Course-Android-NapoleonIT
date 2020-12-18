package com.efimcompany.myweather.feature.ScreenDays.presentation

import com.efimcompany.myweather.WeatherData
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@InjectViewState
class ScreenDaysPresenter: MvpPresenter<ScreenDaysView>() {

    private  val weatherdays: List<WeatherData> = listOf(
        WeatherData("11.12.2020", -11,-21),
        WeatherData("12.12.2020", -12,-22),
        WeatherData("13.12.2020", -13,-23),
        WeatherData("14.12.2020", -14,-24),
        WeatherData("15.12.2020", -15,-25),
        WeatherData("16.12.2020", -16,-26),
        WeatherData("17.12.2020", -17,-27)
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setWeather(weatherdays)
    }
}

interface ScreenDaysView: MvpView{

    @StateStrategyType(SkipStrategy::class)
    fun setWeather(weatherData: List<WeatherData>)

}
