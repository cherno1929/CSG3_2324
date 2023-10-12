package com.example.myapplication

import android.annotation.SuppressLint
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Calendar

class Historial {

    private val dirrPartida = "app\\src\\main\\res\\raw\\data.txt"

    @SuppressLint("NewApi")
    fun getDate() : String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val txt = formatter.format(time)
        return txt
    }

    fun getAllText() : String{
        var txt = "Algo fue mal :("
        /*try{
            txt = File(this.dirrPartida).readText(Charsets.UTF_8)
            if (txt == "") {
                txt = "No hay partidas.txt registradas"
            }
        }catch (ex : Exception){
            txt = "Ups, algo fue mal"
            throw ex
        }*/
        return txt
    }




    fun addPart(newPart:String) {
        /*
        val file = File(this.dirrPartida)
        val writer = BufferedWriter(FileWriter(file, true))
        writer.write(newPart + this.getDate())
        writer.newLine()
        writer.close()
        */
    }

}