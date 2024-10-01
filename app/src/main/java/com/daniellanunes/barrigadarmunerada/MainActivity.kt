package com.daniellanunes.barrigadarmunerada

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    lateinit var btn_entrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        btn_entrar = findViewById(R.id.btn_entrar)
        btn_entrar.setOnClickListener {
            val intent = Intent(this, CalculoActivity::class.java)
            startActivity(intent)
        }

    }

}

