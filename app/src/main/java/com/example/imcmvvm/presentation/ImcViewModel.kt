package com.example.imcmvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imcmvvm.domain.CalcularImcUseCase

class ImcViewModel : ViewModel() {

    private val calcularImc = CalcularImcUseCase()
    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    fun calcular(pesoTexto: String, alturaTexto: String) {
        val peso = pesoTexto.replace(",", ".").toDoubleOrNull()
        val altura = alturaTexto.replace(",", ".").toDoubleOrNull()

        if (peso == null || altura == null || altura <= 0) {
            _resultado.value = "Preencha peso e altura corretamente"
            return
        }

        val imc = calcularImc.executar(peso, altura)
        val classificacao = calcularImc.classificar(imc)

        _resultado.value = "Seu IMC é: %.2f. Você está $classificacao.".format(imc)
    }
}