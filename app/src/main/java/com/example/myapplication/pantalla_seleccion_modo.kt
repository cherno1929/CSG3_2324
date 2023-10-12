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

        butnVsPl.setOnClickListener {
            val intent = Intent(this,PantallaTresEnRaya::class.java)
            startActivity(intent)
        }
        butnVsMch.setOnClickListener {
            val intent = Intent(this,Pantalla3::class.java)
            startActivity(intent)
        }
        butnVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}