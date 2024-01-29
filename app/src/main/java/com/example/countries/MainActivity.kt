package com.example.countries

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.GetCountriesUseCase.CountriesState.Error
import com.example.countries.GetCountriesUseCase.CountriesState.Success

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val rv: RecyclerView = findViewById(R.id.rv_countries)
        val tv: TextView = findViewById(R.id.tv_error)
        rv.layoutManager = LinearLayoutManager(this)
        viewModel.run {
            countries.observe(this@MainActivity) {
                when (it) {
                    is Success -> rv.adapter = CountriesAdapter(it.countries)
                    is Error -> tv.text = it.message
                }
            }
            getCountries()
        }
    }
}