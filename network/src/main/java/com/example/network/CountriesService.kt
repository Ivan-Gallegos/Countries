package com.example.network

import com.example.network.model.Country
import retrofit2.Response
import retrofit2.http.GET


interface CountriesService {
    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/"
    }

    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountries(): Response<List<Country>>

}