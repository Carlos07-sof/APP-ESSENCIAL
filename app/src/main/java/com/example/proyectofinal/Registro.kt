package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.awt.font.TextAttribute

class Registro : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val Correo : TextView = findViewById(R.id.correo)
        val Contraseña : TextView = findViewById(R.id.contraseña)
        val Contraseña2 : TextView = findViewById(R.id.contraseña2)
        val button: Button = findViewById(R.id.buttonregistro)
        button.setOnClickListener(){
            var pass1 = Contraseña.text.toString()
            var pass2 = Contraseña2.text.toString()
            if (pass1.equals(pass2)){
                crearCuenta(Correo.text.toString(), Contraseña.text.toString())
            }
            else{
                Toast.makeText(baseContext, "Error: La contraseña no coinciden", Toast.LENGTH_SHORT).show()
                Contraseña.requestFocus()
            }
        }
        firebaseAuth = Firebase.auth
    }
    private fun crearCuenta(correo: String, contraseña: String){
        firebaseAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(this){
            task ->
            if (task.isSuccessful){
                Toast.makeText(baseContext, "Cuenta creada", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Registro, MenuInicio::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(baseContext, "Algo salio mal. Error: "+task.exception, Toast.LENGTH_SHORT).show()
            }
        }
    }
}