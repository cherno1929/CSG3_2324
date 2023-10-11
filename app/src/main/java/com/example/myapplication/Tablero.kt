package com.example.myapplication

class Tablero {
    private val elements = Array(3) { Array<Char>(3) {'-'} }

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
        var full : Boolean = false
        for (i in 0..2){
            for (j in 0..2){
                if (this.elements[i][j] == '-') {
                    return false
                }
            }
        }
        return full
    }

    fun isOver() : Boolean{
        // "X" is the player
        var winR :Boolean
        var winC :Boolean
        var winD1 :Boolean
        var winD2 :Boolean

        for (i in 0..2) {
            winR = (this.elements[i][0] == this.elements[i][1] && this.elements[i][1] == this.elements[i][2])
            winC = (this.elements[0][i] == this.elements[1][i] && this.elements[1][i] == this.elements[2][i])
            if (winC || winR){
                break
                return true
            }
        }
        winD1 = (this.elements[0][0] == this.elements[1][1] && this.elements[1][1] == this.elements[2][2])
        winD2 = (this.elements[0][2] == this.elements[1][1] && this.elements[1][1] == this.elements[2][0])


        return winD1 || winD2 || this.isFull()
    }

    fun isEmpty(i: Int,j: Int): Boolean{
        return elements[i][j] == '-'
    }

    fun getPos(i: Int, j: Int): Char{
        return elements[i][j]
    }

}