package com.example.kotlinapiclimarecyclerview.models

import com.squareup.moshi.Json

data class ModelClima(

    @Json(name = "Cidade")
    var name: String,

    @Json(name = "Estação")
    val base: String
)
