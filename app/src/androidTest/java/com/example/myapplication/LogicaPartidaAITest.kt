package com.example.myapplication


import org.junit.Assert.assertEquals
import org.junit.Test

class LogicaPartidaAITest {
    @Test
    fun testEstadoPartidaGanaJug1() {
        // Crea un nuevo tablero
        val tablero = Tablero()

        // Marca círculos en una fila para el jugador 1
        tablero.markCircle(0, 0)
        tablero.markCircle(0, 1)
        tablero.markCircle(0, 2)

        // Verifica que el estado de la partida sea GanaJug1
        val gestorTablero = GestorTablero()
        val estadoPartida = gestorTablero.estadoPartida(true)
        assertEquals(/* message = */ "NO GANA EL JUGADOR 1 (ERROR)", /* expected = */
            GestorTablero.PartidaState.GanaJug1, /* actual = */
            estadoPartida)
    }

    @Test
    fun testEstadoPartidaGanaJug2() {
        // Crea un nuevo tablero
        val tablero = Tablero()

        // Marca cruces en una fila para el jugador 2
        tablero.markCross(1, 0)
        tablero.markCross(1, 1)
        tablero.markCross(1, 2)

        // Verifica que el estado de la partida sea GanaJug2
        val gestorTablero = GestorTablero()
        val estadoPartida = gestorTablero.estadoPartida(false)
        assertEquals(/* message = */ "NO GANA EL JUGADOR 2 (ERROR)", /* expected = */
            GestorTablero.PartidaState.GanaJug2, /* actual = */
            estadoPartida)
    }
}

