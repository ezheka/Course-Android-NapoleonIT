package com.efimcompany.myweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import khttp.get
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameCity = intent.extras?.getSerializable("nameCity")

        if(nameCity==null){
            nameCity = "Челябинск"
        }

        textCity.text = "Погода в городе:\n$nameCity"

        buttonWeather_1.setOnClickListener {
            val weather = WeatherData(nameCity.toString(),"05.12.2020", -7,-13)
            val intent = Intent(this, WeatherDetalisActivity::class.java)
            intent.putExtra("WaetherData", weather)
            startActivity(intent)
        }

        buttonWeather_2.setOnClickListener {
            val weather = WeatherData(nameCity.toString(),"06.12.2020", -8,-16)
            val intent = Intent(this, WeatherDetalisActivity::class.java)
            intent.putExtra("WaetherData", weather)
            startActivity(intent)
        }

    }
}


