package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class PantallaOpciones : AppCompatActivity() {
    private var volumeSeekBar: SeekBar? = null

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_opciones)

        val btnBack : Button = findViewById(R.id.back)

        btnBack.setOnClickListener {
            val intent1 = Intent(this,MainMenu::class.java)
            startActivity(intent1)
        }

        volumeSeekBar = findViewById(R.id.volumeSeekBar)

        volumeSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Actualiza el volumen del MediaPlayer según el progreso de la SeekBar
                val volume = progress / 100.0f // Ajusta el valor de 0 a 1
                // Se crea una instancia de la aplicacion para modificar el volumen
                val application = applicationContext as myapp
                application.setVolume(volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No es necesario implementar en este caso
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No es necesario implementar en este caso
            }
        })

        val botonMostrarToast = findViewById<Button>(R.id.unavailable)
        botonMostrarToast.setOnClickListener {
            // Crear y mostrar el Toast al hacer clic en el botón
            val textoToast = "¡Hola, aún estamos trabajando en ello!"
            val duracionToast = Toast.LENGTH_SHORT // Duración corta del Toast
            val toast = Toast.makeText(applicationContext, textoToast, duracionToast)
            toast.show()
        }

        val botonMostrarToast2 = findViewById<Button>(R.id.unavailable2)
        botonMostrarToast2.setOnClickListener {
            // Crear y mostrar el Toast al hacer clic en el botón
            val textoToast = "¡Hola, aún estamos trabajando en ello!"
            val duracionToast = Toast.LENGTH_SHORT // Duración corta del Toast
            val toast = Toast.makeText(applicationContext, textoToast, duracionToast)
            toast.show()
        }

        val botonCreditos = findViewById<Button>(R.id.credits)
        botonCreditos.setOnClickListener {
            mostrarDialogo()
        }

    }

    private fun mostrarDialogo() {
        val mensaje = "Esta aplicación ha sido creada por el equipo de TriquiTech:\n\nJosé, Jorge, Paula, Pedro, Álvaro, Younes, Guillermo, Eloy y Gonzalo"

        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensaje)
            .setCancelable(true)
            .setPositiveButton("Cerrar") { dialog, _ ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }
}