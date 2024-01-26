package com.example.countries

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.logErrorResponse
import com.example.network.model.Country
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val tag = this::class.simpleName
    private val _countries : MutableLiveData<List<Country>> = MutableLiveData()
    val countries :LiveData<List<Country>> = _countries

    fun getCountries(): Job = viewModelScope.launch {
        Repo.getCountries().run {
            if (isSuccessful) body()?.let {
                Log.d(tag, "$it")
                _countries.value = it
            } else logErrorResponse(tag)
        }
    }

}