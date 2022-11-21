package com.example.proyectofinal

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var _imagen = findViewById<LinearLayout>(R.id.LayoutConnected)
        var _imagen1 = findViewById<LinearLayout>(R.id.Layoutdesc)

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        supportActionBar?.hide()
        if (networkInfo != null && networkInfo.isConnected) {
            Handler().postDelayed({
                _imagen.visibility = View.VISIBLE
                _imagen1.visibility = View.GONE
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            },2000)

        } else {
            // No hay conexión a Internet en este momento
            _imagen1.visibility = View.VISIBLE
            _imagen.visibility = View.GONE
        }
    }
}
