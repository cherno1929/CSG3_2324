package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import com.example.myapplication.R

class GestorTablero {
    private lateinit var tablero: Tablero

    enum class PartidaState{
        GanaJug1, GanaJug2, Empate, Continua, JaqueMate
    }

    fun nuevoTablero(): Tablero{
        tablero = Tablero()
        return tablero
    }

    fun faltaUnMovimiento(): Boolean {
        // Check rows and columns
        for (i in 0 until 3) {
            var numMarcRow_X = 0
            var numMarcRow_O = 0
            var numMarcCol_X = 0
            var numMarcCol_O = 0
            for (j in 0 until 3) {
                when (tablero.getPos(i, j)) {
                    'o' -> {
                        numMarcRow_O++
                        numMarcRow_X = 0 // Reiniciar contador de fichas del jugador X
                    }
                    'x' -> {
                        numMarcRow_X++
                        numMarcRow_O = 0 // Reiniciar contador de fichas del jugador O
                    }
                }
                when (tablero.getPos(j, i)) {
                    'o' -> {
                        numMarcCol_O++
                        numMarcCol_X = 0 // Reiniciar contador de fichas del jugador X
                    }
                    'x' -> {
                        numMarcCol_X++
                        numMarcCol_O = 0 // Reiniciar contador de fichas del jugador O
                    }
                }
                if (numMarcRow_O == 2 || numMarcRow_X == 2 || numMarcCol_O == 2 || numMarcCol_X == 2) {
                    return true
                }
            }
        }

        // Check diagonals
        var diag_1_x = 0
        var diag_1_o = 0
        var diag_2_x = 0
        var diag_2_o = 0
        for (i in 0 until 3) {
            when (tablero.getPos(i, i)) {
                'o' -> {
                    diag_1_o++
                    diag_1_x = 0 // Reiniciar contador de fichas del jugador X
                }
                'x' -> {
                    diag_1_x++
                    diag_1_o = 0 // Reiniciar contador de fichas del jugador O
                }
            }
            when (tablero.getPos(i, 2 - i)) {
                'o' -> {
                    diag_2_o++
                    diag_2_x = 0 // Reiniciar contador de fichas del jugador X
                }
                'x' -> {
                    diag_2_x++
                    diag_2_o = 0 // Reiniciar contador de fichas del jugador O
                }
            }
            if (diag_1_x == 2 || diag_1_o == 2 || diag_2_o == 2 || diag_2_x == 2) {
                return true
            }
        }

        return false
    }



    fun estadoPartida(turnoJug1: Boolean): PartidaState {
        if (turnoJug1){
            val fila1 = tablero.getPos(0,0) == 'o' && tablero.getPos(0,1) == 'o' && tablero.getPos(0,2) == 'o'
            val fila2 = tablero.getPos(1,0) == 'o' && tablero.getPos(1,1) == 'o' && tablero.getPos(1,2) == 'o'
            val fila3 = tablero.getPos(2,0) == 'o' && tablero.getPos(2,1) == 'o' && tablero.getPos(2,2) == 'o'
            val col1 = tablero.getPos(0,0) == 'o' && tablero.getPos(1,0) == 'o' && tablero.getPos(2,0) == 'o'
            val col2 = tablero.getPos(0,1) == 'o' && tablero.getPos(1,1) == 'o' && tablero.getPos(2,1) == 'o'
            val col3 = tablero.getPos(0,2) == 'o' && tablero.getPos(1,2) == 'o' && tablero.getPos(2,2) == 'o'
            val diag1 = tablero.getPos(0,0) == 'o' && tablero.getPos(1,1) == 'o' && tablero.getPos(2,2) == 'o'
            val diag2 = tablero.getPos(0,2) == 'o' && tablero.getPos(1,1) == 'o' && tablero.getPos(2,0) == 'o'
            if( fila1 || fila2 || fila3 || col1 || col2 || col3 || diag1 || diag2 ){
                return PartidaState.GanaJug1
            } else if(tablero.isFull()){
                return PartidaState.Empate
            } else{
                if (faltaUnMovimiento()){
                    return PartidaState.JaqueMate
                }
                return PartidaState.Continua
            }
        }
        else{
            val fila1 = tablero.getPos(0,0) == 'x' && tablero.getPos(0,1) == 'x' && tablero.getPos(0,2) == 'x'
            val fila2 = tablero.getPos(1,0) == 'x' && tablero.getPos(1,1) == 'x' && tablero.getPos(1,2) == 'x'
            val fila3 = tablero.getPos(2,0) == 'x' && tablero.getPos(2,1) == 'x' && tablero.getPos(2,2) == 'x'
            val col1 = tablero.getPos(0,0) == 'x' && tablero.getPos(1,0) == 'x' && tablero.getPos(2,0) == 'x'
            val col2 = tablero.getPos(0,1) == 'x' && tablero.getPos(1,1) == 'x' && tablero.getPos(2,1) == 'x'
            val col3 = tablero.getPos(0,2) == 'x' && tablero.getPos(1,2) == 'x' && tablero.getPos(2,2) == 'x'
            val diag1 = tablero.getPos(0,0) == 'x' && tablero.getPos(1,1) == 'x' && tablero.getPos(2,2) == 'x'
            val diag2 = tablero.getPos(0,2) == 'x' && tablero.getPos(1,1) == 'x' && tablero.getPos(2,0) == 'x'
            if(fila1 || fila2 || fila3 || col1 || col2 || col3 || diag1 || diag2){
                return PartidaState.GanaJug2
            } else if(tablero.isFull()){
                return PartidaState.Empate
            } else{
                if (faltaUnMovimiento()){
                    return PartidaState.JaqueMate
                }
                return PartidaState.Continua
            }
        }
    }
}