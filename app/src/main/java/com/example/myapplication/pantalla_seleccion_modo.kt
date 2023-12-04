package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pantalla_seleccion_modo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_seleccion_modo)

        val butnVsPl : Button = findViewById(R.id.button_vsPly)
        val butnVsMch : Button = findViewById(R.id.button_vsPMach)
        val butnVolver : Button = findViewById(R.id.button_goBack)
        val butnHardMode : Button = findViewById(R.id.button_hardMode)
        val butnMidMode : Button = findViewById(R.id.button_middMode)

        butnVsPl.setOnClickListener {
            val intent = Intent(this,PantallaTresEnRaya::class.java)
            startActivity(intent)
        }
        butnVsMch.setOnClickListener {
            val intent = Intent(this,Pantalla3::class.java)
            startActivity(intent)
        }
        butnVolver.setOnClickListener {
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
        butnHardMode.setOnClickListener {
            val intent = Intent(this, Pantalla3_en_raya_dificil::class.java)
            startActivity(intent)
        }
        butnMidMode.setOnClickListener {
            val intent = Intent(this, Modo_Intermedio::class.java)
            startActivity(intent)
        }

    }
}