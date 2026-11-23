package com.example.imcmvvm.domain

import org.junit.Assert.*
import org.junit.Test

class CalcularImcUseCaseTest {

    private val useCase = CalcularImcUseCase()

    @Test
    fun `calcula o IMC corretamente`() {
        val imc = useCase.executar(peso = 53.0, altura = 1.70)

        assertEquals(18.34, imc, 0.01)
    }

    @Test
    fun `IMC baixo e abaixo do peso`() {
        val classificacao = useCase.classificar(17.0)

        assertEquals("Abaixo do peso", classificacao)
    }

    @Test
    fun `IMC exatamente 18 e meio e peso normal`() {
        val classificacao = useCase.classificar(18.5)

        assertEquals("Peso normal", classificacao)
    }

    @Test
    fun `IMC muito alto e Obesidade grau III`() {
        val classificacao = useCase.classificar(45.0)

        assertEquals("Obesidade grau III", classificacao)
    }

}