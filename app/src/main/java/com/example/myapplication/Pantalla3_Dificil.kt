package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import java.io.OutputStreamWriter
import java.lang.Integer.max
import java.lang.Math.min
import java.text.SimpleDateFormat
import java.util.Calendar

class Pantalla3_Dificil : AppCompatActivity() {

    private val gameController = GestorTablero()
    private var tablero = Tablero()
    private var end : Boolean = false
    private var turnoJugador1 : Boolean = true
    private var views = LinkedHashMap<String,ImageView>()
    private val player = 'x'
    private val oponent = 'o'

    fun testFindBestMove(tablero: Array<Array<Char>>): Array<Int> {
        return findBestMove(tablero)
    }

    fun testMinimax(tablero: Array<Array<Char>>, depth: Int, isMaximizingPlayer: Boolean): Int {
        return minimax(tablero, depth, isMaximizingPlayer)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla3)

        val butnVolv : Button = findViewById(R.id.volver)

        inicializarPartida()
        inicializarSensor()

        butnVolv.setOnClickListener {
            val intent1 = Intent(this,MainMenu::class.java)
            startActivity(intent1)
        }
    }

    fun getNextMove() : String{
        val bestMove : Array<Int> = findBestMove(this.tablero.getElements());
        //bestMove = [i,j]
        return bestMove[0].toString() + "_" + bestMove[1].toString()
    }

    private fun findBestMove(board: Array<Array<Char>>): Array<Int> {
        var bestVal = -1000
        var bestMove = arrayOf(-1,-1)

        for (i in 0..2){
            for (j in 0..2){

                if (board[i][j] == '-'){

                    board[i][j] = this.player

                    var moveVal = minimax(board, 0,false)

                    board[i][j] = '-'

                    if (moveVal > bestVal){
                        bestMove = arrayOf(i,j)
                        bestVal = moveVal
                    }

                }

            }
        }
        return  bestMove
    }

    private fun minimax(board: Array<Array<Char>>, depth: Int, isMax: Boolean): Int {
        var score = evaluate(board)

        if ( score == 10 || score == -10){
            return score
        }

        if (!isMovesLeft(board)){
            return 0
        }

        if (isMax){
            var best = -1000

            for (i in 0..2){
                for (j in 0..2){

                    if (board[i][j] == '-'){
                        board[i][j] = this.player
                        best = max(best,minimax(board,depth+1,!isMax))
                        board[i][j] = '-'
                    }
                }
            }
            return best
        }else{
            var best = 1000
            for (i in 0..2){
                for (j in 0..2){

                    if (board[i][j] == '-'){
                        board[i][j] = this.oponent
                        best = min(best,minimax(board,depth+1,!isMax))
                        board[i][j] = '-'
                    }
                }
            }
            return best
        }
    }

    private fun isMovesLeft(board: Array<Array<Char>>): Boolean {
        var valid:Boolean = false
        for (i in 0..2){
            for (j in 0..2){
                valid = (board[i][j] == '-')
                if (valid){
                    break
                }
            }
            if (valid){
                break
            }
        }
        return valid
    }

    private fun evaluate(b: Array<Array<Char>>): Int {
        //Check rows
        for (row in 0..2){
            if (b[row][0] ==  b[row][1] && b[row][1] == b[row][2]){
                if (b[row][0] == this.player){
                    return 10
                }else if (b[row][0] == this.oponent){
                    return -10
                }
            }
        }
        //Check cols
        for (col in 0..2){
            if(b[0][col] == b[1][col] && b[1][col] == b[2][col]){
                if(b[0][col] == this.player){
                    return 10
                }else if(b[0][col] == this.oponent){
                    return -10
                }
            }
        }
        //Check diagonals
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]){
            if (b[0][0] == this.player){
                return 10
            }else if(b[0][0] == this.oponent){
                return -10
            }
        }
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]){
            if (b[1][1] == this.player){
                return 10
            }else if(b[1][1] == this.oponent){
                return -10
            }
        }
        //Space for heuristic
        return getHeuristic(b)
    }

    private fun getHeuristic(b: Array<Array<Char>>): Int{
        return 0;
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
                views[i.toString() + "_" + j.toString()] = ficha
                ficha.setOnClickListener{
                    if(!end && tablero.isEmpty(i,j)) {
                        setFicha(ficha, i, j)
                        var estadoJuego = gameController.estadoPartida(turnoJugador1)
                        if(turnoJugador1 && estadoJuego == GestorTablero.PartidaState.GanaJug1){
                            end = true
                            mostrarMensaje("Ganó el jugador 1")
                            addPart("Ganó el jugador")
                        } else if(estadoJuego == GestorTablero.PartidaState.Empate){
                            end = true
                            mostrarMensaje("El resultado es un empate")
                            addPart("El resultado es un empate")
                        }else{
                            turnoJugador1 = !turnoJugador1
                            var tx = this.getNextMove()
                            var fila = tx.split("_")[0].toInt()
                            var colm = tx .split("_")[1].toInt()
                            this.views.get(tx)?.let { it1 -> this.setFicha(it1,fila,colm) }

                            estadoJuego = gameController.estadoPartida(turnoJugador1)
                             if(!turnoJugador1 && estadoJuego == GestorTablero.PartidaState.GanaJug2) {
                                 end = true
                                 mostrarMensaje("Ganó el jugador 2")
                                 addPart("Perdio el jugador")
                             }
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