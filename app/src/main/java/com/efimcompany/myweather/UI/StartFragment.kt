package com.efimcompany.myweather.UI

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.efimcompany.myweather.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonGoTo7Day.setOnClickListener{

            if (editTextTextCity.text.isNotEmpty()){
                requireFragmentManager().beginTransaction()
                    .replace(R.id.container, Weather7DayFragment.newInstance(editTextTextCity.text.toString()))
                    .addToBackStack("Weather7DayFragment")
                    .commit()
            }
        }
    }
}