package com.example.kotlinapiclimarecyclerview.repository

import com.example.kotlinapiclimarecyclerview.interfaces.InterfaceWeb
import com.example.kotlinapiclimarecyclerview.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConfigRetrofit {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val getService: InterfaceWeb by lazy {
        retrofit.create(InterfaceWeb::class.java)
    }

}

