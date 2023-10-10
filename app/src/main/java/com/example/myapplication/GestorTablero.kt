package com.example.myapplication

class GestorTablero {
    private lateinit var tablero: Array<Array<Char>>

    fun nuevoTablero(): Array<Array<Char>>{
        tablero = Array(size = 3, { Array(3, {'-'}) })
        return tablero
    }
}