package com.example.myapplication

class Bot(var elements : Array<Array<Char>>) {

    fun getRandom() : String{
        var value = ""
        for (i in 0..2) {
            for (j in 0..2){
                if (this.elements[i][j] == '-'){
                    value = i.toString() + "-" +j.toString()
                    break
                }
            }
        }
        return value
    }

}