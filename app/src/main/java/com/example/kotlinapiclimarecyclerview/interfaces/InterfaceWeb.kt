package com.example.kotlinapiclimarecyclerview.interfaces

import com.example.kotlinapiclimarecyclerview.models.ModelClima
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface InterfaceWeb {

    @GET("data/2.5/weather?")
    fun consultandoClimaI (
        @Query("q") cidade: String,
        @Query("appid") API_KEY: String,
        @Query("lang") idioma: String,
        @Query("units") metric: String
    ) : Call<ModelClima>


//https://api.openweathermap.org/
// data/2.5/weather?
// q=Agrestina&
// appid=70c7006c98c1a2e32a1cdb95e763da0f&
// lang=pt_br&
// units=metric
}