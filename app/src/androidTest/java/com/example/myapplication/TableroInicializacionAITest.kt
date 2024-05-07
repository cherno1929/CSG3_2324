package com.example.myapplication

import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test

class TableroInicializacionAITest {
    private lateinit var pantalla3: Pantalla3_Dificil

    @Before
    fun setUp() {
        pantalla3 = Pantalla3_Dificil()
    }

    @Test
    fun tableroInicializacionAITest() {
        // Inicializa una nueva partida
        pantalla3.inicializarPartida()

        // Obtiene el tablero actual después de la inicialización
        val tableroActual = pantalla3.tablero.getElements()

        // Verifica que todos los elementos del tablero estén vacíos al inicio de una nueva partida
        val tableroEsperado = Array(3) { Array(3) { '-' } }
        assertArrayEquals("TABLERO NO VACIO (ERROR)", tableroEsperado, tableroActual)
    }

}


