package com.example.imcmvvm.domain

class CalcularImcUseCase {

    fun executar(peso: Double, altura: Double) = peso / (altura * altura)


    fun classificar(imc: Double) = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25 -> "Peso normal"
            imc < 30 -> "Sobrepeso"
            imc < 35 -> "Obesidade grau I"
            imc < 40 -> "Obesidade grau II"
            else -> "Obesidade grau III"

    }
}