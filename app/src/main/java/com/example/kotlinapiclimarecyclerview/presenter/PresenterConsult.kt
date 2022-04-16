package com.example.kotlinapiclimarecyclerview.presenter

import android.util.Log
import com.example.kotlinapiclimarecyclerview.interfaces.ContratoPresenter
import com.example.kotlinapiclimarecyclerview.models.ModelClima
import com.example.kotlinapiclimarecyclerview.repository.ConfigRetrofit
import com.example.kotlinapiclimarecyclerview.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterConsult(view_: ContratoPresenter.ContratoView) : ContratoPresenter.ContratoAPI {
    var editText: String? = null

    private val view: ContratoPresenter.ContratoView = view_

    override fun obtendoApi() {
        val call: Call<ModelClima> = ConfigRetrofit()
            .getService
            .consultandoClimaI(
                view.passandoEdit(editText.toString()),
                Constants.API_KEY,
                Constants.IDIOMA,
                Constants.METRIC
            )
        call.enqueue(object : Callback<ModelClima> {
            override fun onResponse(call: Call<ModelClima>, response: Response<ModelClima>) {
                if (response.isSuccessful) {
                    val result: ModelClima? = response.body()
                    view.viewResult(result)
                    Log.i("TAG", " Resulted retrofit no Presenter ***************** $result")
                }
            }

            override fun onFailure(call: Call<ModelClima>, t: Throwable) {
                view.mostrarError()
            }

        })
    }
}