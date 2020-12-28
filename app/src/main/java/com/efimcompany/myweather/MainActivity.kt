package com.efimcompany.myweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.efimcompany.myweather.ui.StartFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager


        fragmentManager.beginTransaction()
            .add(R.id.container, StartFragment())
            .commit()

    }
}