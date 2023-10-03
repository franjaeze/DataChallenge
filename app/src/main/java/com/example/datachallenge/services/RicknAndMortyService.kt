package com.example.datachallenge.services

import com.example.datachallenge.model.PaginateResponse
import com.example.datachallenge.model.Personaje
import retrofit2.Call
import retrofit2.http.GET

interface RicknAndMortyService {


    @GET("api/character")
    fun getCharacters (): Call<PaginateResponse<Personaje>>

//    @GET("api/v2/ability")
//    fun getAbility (): Call<PaginateResponse<Ability>>
//
}