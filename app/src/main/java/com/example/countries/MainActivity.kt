package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val tv: TextView = findViewById(R.id.tv_hello)
        viewModel.run {
            countries.observe(this@MainActivity) {
                tv.text = it.toString()
            }
            getCountries()
        }
    }
}