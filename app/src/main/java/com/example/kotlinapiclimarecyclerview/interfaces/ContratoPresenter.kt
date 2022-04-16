package com.example.kotlinapiclimarecyclerview.interfaces

import android.widget.EditText
import com.example.kotlinapiclimarecyclerview.models.ModelClima

interface ContratoPresenter {

    interface ContratoAPI {
        fun obtendoApi()
    }

    interface ContratoView {
        fun passandoEdit(editText: String) : String
        fun viewResult(resultadoAPI: ModelClima?)
        fun mostrarError()
    }
}