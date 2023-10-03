package com.example.datachallenge.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ActivityServiceApiBuilder {
    private val BASE_URL = "https://rickandmortyapi.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): RicknAndMortyService {
        return retrofit.create(RicknAndMortyService::class.java)
    }
}