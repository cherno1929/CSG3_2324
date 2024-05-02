package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Pantalla2 : AppCompatActivity() {

    private var file: String = "data.txt"

    fun setFile(file:String){
        this.file = file
    }

    fun deleteHist(){
        val archivo = File(filesDir,file)

        if (archivo.exists()){
            archivo.delete()
            Toast.makeText(this, "Historial borrado correctamente", Toast.LENGTH_SHORT).show()
        } else {
            archivo.createNewFile()
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        llenarData()
        val btn2: Button = findViewById(R.id.butnDeleteHist)
        val btn: Button = findViewById(R.id.butnGoBack)
        btn.setOnClickListener{
            val intent1 = Intent(this,MainMenu::class.java)
            startActivity(intent1)
        }

        btn2.setOnClickListener{
            deleteHist()
            val intent1 = Intent(this,Pantalla2::class.java)
            startActivity(intent1)
        }
    }

    fun llenarData(){
        val textZone :TextView = findViewById(R.id.textPartidas)
        textZone.text = leerArchivo()
    }

    fun leerArchivo(): String {
        var txt = "Error al leer los archivos"
        try {
            val fin = BufferedReader(InputStreamReader(openFileInput(file)))
            txt = ""
            fin.useLines { lines ->
                lines.forEach {
                    txt += it + "\n"
                }
            }
        } catch (ex: java.lang.Exception) {
            Log.e("Ficheros", "Error al leer el fichero desde la memoria interna")
        }
        return txt
    }

    fun guardarPartida(text:String){
        try {
            val fout = OutputStreamWriter(openFileOutput(this.file, MODE_APPEND))
            fout.write(text)
            fout.write("\n")
            fout.close()
        } catch (ex: Exception) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna")
        }
    }

    fun destroyThisFile(): Boolean {
        val fileToDestroy = File(file)
        val idDestroyed = fileToDestroy.delete()
        return idDestroyed
    }
}