package com.example.datachallenge.model

data class PaginateResponse <T>(// la data class es similar a un enum,
                                // es una lista que no cambia. Va a quedar asi
    val info: Info,
//    val next:String?,
//    val previous:String?,
    val results:List<T>
)