package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.butnplay)
        val btnH: Button = findViewById(R.id.butnhist)
        btn.setOnClickListener{
            val intent1 = Intent(this,pantalla_seleccion_modo::class.java)
            startActivity(intent1)
        }
        btnH.setOnClickListener{
            val intent2 = Intent(this,Pantalla2::class.java)
            startActivity(intent2)
        }
    }
}