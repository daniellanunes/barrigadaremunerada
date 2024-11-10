package com.daniellanunes.barrigadarmunerada

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvLista : RecyclerView
    lateinit var btnNovaConsulta : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        btnNovaConsulta = findViewById(R.id.btn_nova_consulta)

        btnNovaConsulta.setOnClickListener {
            val intent = Intent(this, CalculoActivity::class.java)

            startActivity(intent)
        }

        val bundle = intent.extras
        if (bundle != null){

            var valor = bundle.getString("valor")
            var data = bundle.getString("data")
            var tempo = bundle.getInt("time")




            val lista = mutableListOf<Dados>()
            val adaptador = DadosAdapter(lista)
            var novoDados = Dados ("Data: $data", "Tempo: $tempo min","Economia: R$ $valor" )
            adaptador.adicionarDados(novoDados)

            //lista.add(Dados("Data: ${data.toString()}", "Tempo: ${tempo.toString()}min", "Valor: ${valor.toString()}"))


            rvLista = findViewById(R.id.rv_lista)
            //rvLista.adapter = DadosAdapter(lista)
            rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvLista.adapter = adaptador
            //rvLista.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))



        }

       /* val lista = listOf(
            Dados("22/10/2024", "60 Min", "R$ 7,30"),
            Dados("22/10/2024", "60 Min", "R$ 7,30"),
            Dados("22/10/2024", "60 Min", "R$ 7,30"),
            Dados("22/10/2024", "60 Min", "R$ 7,30"),
            Dados("22/10/2024", "60 Min", "R$ 7,30"),
            Dados("22/10/2024", "60 Min", "R$ 7,30")
        )


        rvLista = findViewById(R.id.rv_lista)
        rvLista.adapter = DadosAdapter(lista)
        rvLista.layoutManager = LinearLayoutManager(this)*/



    }
}