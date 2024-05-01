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
        GanaJug1, GanaJug2, Empate, Continua
    }

    fun nuevoTablero(): Tablero{
        tablero = Tablero()
        return tablero
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
                return PartidaState.Continua
            }
        }
    }
}