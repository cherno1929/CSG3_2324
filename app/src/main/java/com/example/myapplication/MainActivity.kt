package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val imgTeam : ImageView = findViewById(R.id.trichTeam)

        imgTeam.setOnClickListener{
            val intent1 = Intent(this,MainMenu::class.java)
            startActivity(intent1)
        }
    }

}