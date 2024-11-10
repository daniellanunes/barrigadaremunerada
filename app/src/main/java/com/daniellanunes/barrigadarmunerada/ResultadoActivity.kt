package com.daniellanunes.barrigadarmunerada

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    lateinit var textSalario : TextView
    lateinit var textHorasT : TextView
    lateinit var textMin : TextView
    lateinit var textResult : TextView
    lateinit var btnHistorico : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        componetesInterface()



        val bundle = intent.extras
        if (bundle != null){

            val salario = bundle.getString("salario")
            val horasT = bundle.getString("horas")
            val minB = bundle.getInt("min")
            val resultado = bundle.getString("resultado")
            val data = bundle.getString("data")

            textSalario.text = "Salário Informado: R$ $salario"
            textHorasT.text = "Horas trabalhadas do mês: $horasT Hrs"
            textMin.text = "Minutos de Barrigada do dia: $minB min"
            textResult.text = "Parabéns, você transformou sua Barrigada em R$ $resultado !"

            btnHistorico.setOnClickListener {
                val intent = Intent(this, RecyclerViewActivity::class.java)

                intent.putExtra("data", data)
                intent.putExtra("time", minB)
                intent.putExtra("valor", resultado)

                startActivity(intent)
            }

        }


    }

    private fun componetesInterface() {
        btnHistorico = findViewById(R.id.btn_historico)
        textSalario = findViewById(R.id.text_dados_salario)
        textHorasT = findViewById(R.id.text_dados_horas)
        textMin = findViewById(R.id.text_dados_min)
        textResult = findViewById(R.id.text_result)

    }
}