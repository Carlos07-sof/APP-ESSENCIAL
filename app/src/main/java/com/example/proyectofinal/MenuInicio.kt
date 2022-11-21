package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuInicio : AppCompatActivity() {
    var num = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_inicio)
        var btnsuma = findViewById<Button>(R.id.bottonsuma)
        var btnresta = findViewById<Button>(R.id.buttonresta)
        var cant = findViewById<TextView>(R.id.textcant)

        btnsuma.setOnClickListener{
            num++
            cant.text = num.toString()


        }
        btnresta.setOnClickListener{
            if (num <= 0){
                num = 0;
            }
            else{
                num--
            }
            cant.text = num.toString()

        }
    }
}