package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.Calendar


class Historial {

    private var dirrPartida = "data/app/com.example.myapplication"
    private lateinit var fileName: File

    @SuppressLint("NewApi")


    fun getAllText() : String{
        var txt = "Algo fue mal :("
        if(!this.fileName.exists()){
            this.fileName = File(this.dirrPartida + "/data.txt")
        }
        try{
            txt = this.fileName.readText(Charsets.UTF_8)
            if (txt == "") {
                txt = "No hay partidas.txt registradas"
            }
        }catch (ex : Exception){
            txt = "Ups, algo fue mal"
            throw ex
        }
        return txt
    }

    fun setDir(filesDir: String) {
        this.fileName = File(this.dirrPartida + "/data.txt")
    }



}