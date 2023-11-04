package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val btnSt : Button = findViewById(R.id.butnplay)
       val btnHs : Button = findViewById(R.id.butnhist)

       btnSt.setOnClickListener {
           val intent1 = Intent(this,pantalla_seleccion_modo::class.java)
           startActivity(intent1)
       }

        btnHs.setOnClickListener {
            val intent1 = Intent(this,Pantalla2
            ::class.java)
            startActivity(intent1)
        }

    }
}

