package com.example.datachallenge.model

import android.os.Parcelable
import java.io.Serializable

data class Personaje(
    // data class es como un enum, una lista que no va a cambiar
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode:List<String>,
    val url: String,
    val created: String

): Serializable