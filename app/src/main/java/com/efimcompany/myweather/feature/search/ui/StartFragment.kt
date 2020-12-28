package com.efimcompany.myweather.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.efimcompany.myweather.R
import com.efimcompany.myweather.feature.screenDays.ui.Weather7DayFragment
import com.efimcompany.myweather.feature.search.presentation.SearchPresenter
import com.efimcompany.myweather.feature.search.presentation.SearchView
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment(R.layout.fragment_start), SearchView {

    private var lat: Double = 55.753215
    private var lon: Double = 37.622504
    private val presenter = SearchPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

                    presenter.savingCoordinates("$lon $lat")
                }
                requireFragmentManager().beginTransaction()
                    .replace(R.id.container,
                        Weather7DayFragment.newInstance(
                            editTextTextCity.text.toString(),
                            lat, lon
                        ))
                    .addToBackStack("Weather7DayFragment")
                    .commit()
            }
        }
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
