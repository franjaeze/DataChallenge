package com.example.datachallenge.model

data class Ability ( // data class es como un enum, una lista que no va a cambiar
    val type : String,
    val participants: Int?,
    val price : Double?
)