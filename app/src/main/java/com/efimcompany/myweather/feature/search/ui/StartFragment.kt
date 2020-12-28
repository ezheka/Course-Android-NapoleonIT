package com.efimcompany.myweather.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.efimcompany.myweather.R
import com.efimcompany.myweather.di.geoApi
import com.efimcompany.myweather.domain.GetGeoUseCase
import com.efimcompany.myweather.feature.screenDays.ui.Weather7DayFragment
import com.efimcompany.myweather.feature.search.presentation.SearchPresenter
import com.efimcompany.myweather.feature.search.presentation.SearchView
import kotlinx.android.synthetic.main.fragment_start.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StartFragment : MvpAppCompatFragment(R.layout.fragment_start), SearchView {

    private var lat: Double = 55.753215
    private var lon: Double = 37.622504
    private var cityName:String = "Москва"

    private val presenter: SearchPresenter by moxyPresenter{
        SearchPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(false)
        initListeners()
    }

    private fun initListeners() {

        buttonGoTo7Day.setOnClickListener{
            if(presenter.validate(
                editTextTextCity.text.toString(),
                etLatitude.text.toString(),
                etLongitube.text.toString()
            ))
            {
                if (etLatitude.text.isNotEmpty() && etLongitube.text.isNotEmpty()){
                    lat = etLatitude.text.toString().toDouble()
                    lon = etLongitube.text.toString().toDouble()

                    openWeatherDaysFragment("$lon $lat")
                }

                if(editTextTextCity.text.isNotEmpty()){
                    showLoading(true)
                    cityName = editTextTextCity.text.toString()
                    presenter.onSearchCity(GetGeoUseCase(geoApi, cityName))
                }
            }
        }
    }

    override fun openWeatherDaysFragment(coordinates: String){
        requireFragmentManager().beginTransaction()
            .replace(R.id.container,
                Weather7DayFragment.newInstance(coordinates)
            )
            .addToBackStack("Weather7DayFragment")
            .commit()
    }

    override fun showLoading(isShow: Boolean) {
        geoProgress.isVisible = isShow
    }

    override fun showNameCityError() {
        showError("в поле Город")
    }

    override fun showCoordinatesError() {
        showError("в поле Координаты")
    }

    override fun showAllError() {
        showError("Все поля пустые")
    }

    private  fun showError(name: String){
        Toast.makeText(requireContext(), "Ошибка! $name", Toast.LENGTH_LONG).show()
    }
}
