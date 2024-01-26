package com.example.countries

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val rv: RecyclerView = findViewById(R.id.rv_countries)
        rv.layoutManager = LinearLayoutManager(this)
        viewModel.run {
            countries.observe(this@MainActivity) {
                rv.adapter = CountriesAdapter(it)
            }
            getCountries()
        }
    }
}