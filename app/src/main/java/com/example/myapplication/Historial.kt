package com.example.myapplication

import android.annotation.SuppressLint
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Calendar

class Historial {

    private val dirrPartida = "partidas.txt"

    @SuppressLint("NewApi")
    fun getDate() : String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val txt = formatter.format(time)
        return txt
    }

    fun getAllText() : String{
        var txt = ""
        try{
            txt = File(this.dirrPartida).readText(Charsets.UTF_8)
            if (txt == "") {
                txt = "No hay partidas.txt registradas"
            }
        }catch (ex : Exception){
            txt = "Ups, algo fue mal"
            throw ex
        }
        return txt
    }


    fun addPart(newPart:String) {
        val tx = newPart + " " + this.getDate()
        val file = File(this.dirrPartida)
        if (file.exists()){
            try {
                val fileOut = FileOutputStream(file, true)
                fileOut.write(tx.toByteArray())
                fileOut.close()
            } catch (ex: Exception) {
                throw ex
            }
        }
    }

}