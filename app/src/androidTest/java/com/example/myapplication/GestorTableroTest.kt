package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

class GestorTableroTest {

    @Test
    fun testUltimoMovimientoParaGanar() {
        // Arrange
        val gestorTablero = GestorTablero()
        val tablero = gestorTablero.nuevoTablero()

        // Agrega algunas fichas al tablero
        tablero.setPos(0, 0, 'o')
        tablero.setPos(1, 1, 'x')
        tablero.setPos(0, 1, 'o')
        tablero.setPos(2, 2, 'x')

        // Act
        val JaqueMate = gestorTablero.faltaUnMovimiento()

        // Assert
        assertFalse(JaqueMate)
    }

    @Test
    fun testNoUltimoMovimientoParaGanar() {
        // Arrange
        val gestorTablero = GestorTablero()
        val tablero = gestorTablero.nuevoTablero()

        // Agrega algunas fichas al tablero
        tablero.setPos(0, 0, 'o')
        tablero.setPos(0, 1, 'x')
        tablero.setPos(1, 1, 'o')
        tablero.setPos(2, 2, 'x')

        // Act
        val ultimoMovimientoParaGanar = gestorTablero.faltaUnMovimiento()

        // Assert
        assertFalse(ultimoMovimientoParaGanar)
    }

    @Test
    fun testUltimoMovimientoParaPerder() {
        // Arrange
        val gestorTablero = GestorTablero()
        val tablero = gestorTablero.nuevoTablero()

        // Agrega algunas fichas al tablero
        tablero.setPos(0, 0, 'x')
        tablero.setPos(0, 1, 'x')
        tablero.setPos(1, 1, 'o')
        tablero.setPos(2, 2, 'o')

        // Act
        val ultimoMovimientoParaPerder = gestorTablero.faltaUnMovimiento()

        // Assert
        assertFalse(ultimoMovimientoParaPerder)
    }

    @Test
    fun testNoUltimoMovimientoParaPerder() {
        // Arrange
        val gestorTablero = GestorTablero()
        val tablero = gestorTablero.nuevoTablero()

        // Agrega algunas fichas al tablero
        tablero.setPos(0, 0, 'x')
        tablero.setPos(0, 1, 'o')
        tablero.setPos(1, 1, 'x')
        tablero.setPos(2, 2, 'o')

        // Act
        val ultimoMovimientoParaPerder = gestorTablero.faltaUnMovimiento()

        // Assert
        assertFalse(ultimoMovimientoParaPerder)
    }
}
