package com.daniellanunes.barrigadarmunerada

import android.os.Bundle
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

            textSalario.text = "Salário Informado: R$ $salario"
            textHorasT.text = "Horas trabalhadas do mês: $horasT Hrs"
            textMin.text = "Minutos de Barrigada do dia: $minB min"
            textResult.text = "Parabéns, você transformou sua Barrigada em R$ $resultado !"

        }

    }

    private fun componetesInterface() {

        textSalario = findViewById(R.id.text_dados_salario)
        textHorasT = findViewById(R.id.text_dados_horas)
        textMin = findViewById(R.id.text_dados_min)
        textResult = findViewById(R.id.text_result)

    }
}