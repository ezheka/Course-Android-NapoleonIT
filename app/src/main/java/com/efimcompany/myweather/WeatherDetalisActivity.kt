package com.efimcompany.myweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_weather_detalis.*

class WeatherDetalisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detalis)

        val waetherData = intent.extras?.getSerializable("WaetherData") as WeatherData

        textHeaderDetalis.text = "Погода на \n${waetherData.date}"
        textWeather.text = waetherData.temp.toString()
        textWeather_2.text = "Ощущается как: ${waetherData.temp_2}"

        buttonOpenStartActivity.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            if(waetherData.city=="Челябинск") intent.putExtra("nameCity", "Еткуль")
            else intent.putExtra("nameCity", "Челябинск")
            startActivity(intent)
        }
    }
}