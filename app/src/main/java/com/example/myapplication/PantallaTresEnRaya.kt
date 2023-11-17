package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.Calendar

class PantallaTresEnRaya : AppCompatActivity() {
    private val gameController = GestorTablero()
    private lateinit var tablero: Tablero
    private var end = false
    private var turnoJugador1 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_tres_en_raya)

        inicializarPartida()
        inicializarSensor()

        val btnvolver: Button = findViewById(R.id.volver)
        btnvolver.setOnClickListener{
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }

    private fun inicializarPartida(){
        tablero = gameController.nuevoTablero()
        end = false
        turnoJugador1 = true
        val tableroLayout = findViewById<LinearLayout>(R.id.tableroLayout)
        for (i in 0 until tableroLayout.childCount) {
            val fila = tableroLayout[i] as LinearLayout
            for (j in 0 until fila.childCount) {
                val ficha = fila[j] as ImageView
                ficha.setImageDrawable(getDrawable(R.drawable.cuadrado))
            }
        }
    }

    private fun inicializarSensor(){
        val reiniciar = findViewById<Button>(R.id.reiniciar)
        reiniciar.setOnClickListener(){
            inicializarPartida()
        }
        val tableroLayout = findViewById<LinearLayout>(R.id.tableroLayout)
        for(i in 0 until tableroLayout.childCount){
            val fila = tableroLayout[i] as LinearLayout
            for (j in 0 until fila.childCount){
                val ficha = fila[j] as ImageView
                ficha.setOnClickListener{
                    if(!end && tablero.isEmpty(i,j)) {
                        setFicha(ficha, i, j)
                        val estadoJuego = gameController.estadoPartida(turnoJugador1)
                        if(turnoJugador1 && estadoJuego == GestorTablero.PartidaState.GanaJug1){
                            end = true
                            mostrarMensaje("Ganó el jugador 1")
                            addPart("Ganó el jugador 1")
                        }else if(!turnoJugador1 && estadoJuego == GestorTablero.PartidaState.GanaJug2){
                            end = true
                            mostrarMensaje("Ganó el jugador 2")
                            addPart("Ganó el jugador 2")
                        } else if(estadoJuego == GestorTablero.PartidaState.Empate){
                            end = true
                            mostrarMensaje("El resultado es un empate")
                            addPart("El resultado es un empate")
                        } else{
                            turnoJugador1 = !turnoJugador1
                        }
                    }
                }
            }

        }
    }

    private fun mostrarMensaje(mensaje: String){
        AlertDialog.Builder(this)
            .setTitle(mensaje)
            .setPositiveButton("Jugar de nuevo", { dialog, which -> inicializarPartida() })
            .setNegativeButton("Cancelar", { dialog, which -> dialog.dismiss() })
            .show()
    }

    private fun setFicha(view: ImageView, posFila: Int, posCol: Int){
        if(turnoJugador1) {
            tablero.markCircle(posFila, posCol)
            view.setImageDrawable(getDrawable(R.drawable.circulo))
        }
        else{
            tablero.markCross(posFila, posCol)
            view.setImageDrawable(getDrawable(R.drawable.cruz))
        }
    }

    fun guardarArchivo(texto: String) {
        try {
            val fout = OutputStreamWriter(openFileOutput("data.txt", MODE_APPEND))
            fout.write(texto)
            fout.write("\n")
            fout.close()
        } catch (ex: Exception) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna")
        }
    }

    fun getDate() : String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val txt = formatter.format(time)
        return txt
    }

    fun addPart(newPart:String) {
        var text = newPart + " " + this.getDate()
        guardarArchivo(text)
    }

}