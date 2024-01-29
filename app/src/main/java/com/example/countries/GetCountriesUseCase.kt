package com.example.countries

import com.example.network.logErrorResponse
import com.example.network.logSuccessResponse
import com.example.network.model.Country

class GetCountriesUseCase(private val countriesRepository: CountriesRepository) {
    private val tag = this::class.simpleName

    suspend operator fun invoke(): CountriesState {
        countriesRepository.getCountries().run {
            val body = body()
            return if (isSuccessful && body != null) body.let {
                logSuccessResponse(tag)
                CountriesState.Success(it)
            } else {
                logErrorResponse(tag)
                CountriesState.Error(errorBody()?.string().orEmpty())
            }
        }
    }

    sealed class CountriesState {
        class Success(val countries: List<Country> = listOf()) : CountriesState()

        class Error(val message: String = "") : CountriesState()
    }
}