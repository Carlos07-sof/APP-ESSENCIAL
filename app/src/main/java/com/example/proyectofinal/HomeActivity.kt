package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.sql.CallableStatement
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Types

class HomeActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var _correo = findViewById<TextView>(R.id.textcorreo)
        var _contraseña = findViewById<TextView>(R.id.textcontraseña)
        var textinic = findViewById<TextView>(R.id.registrarView)
        var btnprincipal = findViewById<Button>(R.id.buttonIngresar)
        firebaseAuth = Firebase.auth

        btnprincipal.setOnClickListener(View.OnClickListener {
            Iniciar_sesion(_correo.text.toString(), _contraseña.text.toString());
        });
        textinic.setOnClickListener{
            val intent = Intent(this@HomeActivity, Registro::class.java)
            startActivity(intent)
        }

    }
    fun Iniciar_sesion(correo : String, contraseña: String) {
        firebaseAuth.signInWithEmailAndPassword(correo, contraseña).addOnCompleteListener(this){
            task->
            if (task.isSuccessful){
                Toast.makeText(baseContext, "Datos correctos", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@HomeActivity, MenuInicio::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(baseContext, "Error: Email y/o Contraseña son incorrectas", Toast.LENGTH_SHORT).show()
            }

        }
    }

}