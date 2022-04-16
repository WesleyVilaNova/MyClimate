package com.example.kotlinapiclimarecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinapiclimarecyclerview.R
import com.example.kotlinapiclimarecyclerview.databinding.ActivityMainBinding
import com.example.kotlinapiclimarecyclerview.interfaces.ContratoPresenter
import com.example.kotlinapiclimarecyclerview.models.ModelClima
import com.example.kotlinapiclimarecyclerview.presenter.PresenterConsult

class MainActivity : AppCompatActivity(), ContratoPresenter.ContratoView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var editTextCidade: EditText

    private val view: ContratoPresenter.ContratoAPI = PresenterConsult(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciandoComponentes()
    }

    override fun passandoEdit(editText: String): String {
        return editTextCidade.text.toString()
    }

    override fun viewResult(resultadoAPI: ModelClima?) {
    }

    override fun mostrarError() {
        Toast.makeText(this, "Ocorreu um error ao consultar", Toast.LENGTH_LONG).show()
    }

    private fun iniciandoComponentes() {
        editTextCidade = findViewById(R.id.editText_cidade)
        binding.btnConsultar.setOnClickListener {
            if (binding.editTextCidade.length() == 0) {
                binding.editTextCidade.error = "Digite o nome da cidade"
            } else {
                view.obtendoApi()
            }
        }
    }
}