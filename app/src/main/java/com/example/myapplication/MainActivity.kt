package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import com.example.myapplication.R
import com.example.myapplication.GestorTablero

class MainActivity : AppCompatActivity() {
    private val gameController = GestorTablero()
    private lateinit var tablero: Tablero
    private var end = false
    private var turnoJugador1 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarPartida()
        inicializarSensor()
    }

    private fun inicializarPartida(){
        tablero = gameController.nuevoTablero()
        end = false
        turnoJugador1 = true
    }

    private fun inicializarSensor(){
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
                        }else if(!turnoJugador1 && estadoJuego == GestorTablero.PartidaState.GanaJug2){
                            end = true
                        } else if(estadoJuego == GestorTablero.PartidaState.Empate){
                            end = true
                        } else{
                            turnoJugador1 = !turnoJugador1
                        }
                    }
                }
            }

        }
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


}