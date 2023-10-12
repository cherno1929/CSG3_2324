package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Pantalla2 : AppCompatActivity() {

    var histPart = Historial()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        this.llenarData()

        val btn: Button = findViewById(R.id.butnGoBack)
        btn.setOnClickListener{
            val intent1 = Intent(this,MainActivity::class.java)
            startActivity(intent1)
        }
    }

    fun llenarData(){
        val textZone :TextView = findViewById(R.id.textPartidas)
        textZone.text = this.histPart.getAllText()
    }
}