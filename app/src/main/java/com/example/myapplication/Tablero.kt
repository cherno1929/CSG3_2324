package com.example.myapplication

class Tablero {
    private val elements = Array(3) { Array<Char>(3) {'-'} }

    fun getElements(): Array<Array<Char>> {
        return this.elements
    }

    fun markCircle(x : Int, y : Int){
        if (x < elements.size && y < elements[0].size) {
            this.elements[x][y] = 'o'
        }
    }

    fun markCross(x : Int, y : Int){
        if (x < elements.size && y < elements[0].size) {
            this.elements[x][y] = 'x'
        }
    }

    fun isFull(): Boolean {
        var full : Boolean = true
        for (i in 0..2){
            for (j in 0..2){
                if (this.elements[i][j] == '-') {
                    return false
                }
            }
        }
        return full
    }

    fun isEmpty(i: Int,j: Int): Boolean{
        return elements[i][j] == '-'
    }

    fun getPos(i: Int, j: Int): Char{
        return elements[i][j]
    }

}