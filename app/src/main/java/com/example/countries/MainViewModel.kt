package com.example.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.GetCountriesUseCase.CountriesState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _countries: MutableLiveData<CountriesState> = MutableLiveData()
    val countries: LiveData<CountriesState> = _countries
    fun getCountries(): Job = viewModelScope.launch {
        _countries.value = GetCountriesUseCase(CountriesRepository)()
    }
}