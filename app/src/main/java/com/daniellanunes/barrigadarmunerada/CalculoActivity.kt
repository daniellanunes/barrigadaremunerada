package com.daniellanunes.barrigadarmunerada

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CalculoActivity : AppCompatActivity() {
    lateinit var textInputHrsTrab : TextInputLayout
    lateinit var editHrsTrab : TextInputEditText

    lateinit var textInputSalario   : TextInputLayout
    lateinit var editSalario   : TextInputEditText

    lateinit var textInputTempo     : TextInputLayout
    lateinit var editTempo     : TextInputEditText

    lateinit var textInputData : TextInputLayout
    lateinit var editData : TextInputEditText

    //lateinit var textResultado : TextView
    lateinit var btnCalcular   : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculo)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener {
            val intent = Intent (this, ResultadoActivity::class.java)
            //calcularResultado()
            var horasTrab = editHrsTrab.text.toString()
            var salario = editSalario.text.toString()

            var horaSalario = salario.toDouble() / horasTrab.toDouble()
            var minSalario = horaSalario / 60.0

            var tempoMin = editTempo.text.toString()
            var tempoH = tempoMin.toInt()

            var numero = minSalario * tempoH
            var resultado = String.format("%.2f", numero)

            val data = editData.text.toString()
            intent.putExtra("data", data)
            intent.putExtra("salario",salario)
            intent.putExtra("horas",horasTrab)
            intent.putExtra("min",tempoH) //int
            intent.putExtra("resultado", resultado)

           // textResultado.text = "Parabéns! Você transformou sua barrigada em R$ ${resultado}"

            startActivity(intent)
        }
    }

  /*  private fun calcularResultado() {

        var horasTrab = editHrsTrab.text.toString()
        var salario = editSalario.text.toString()

        var horaSalario = salario.toDouble() / horasTrab.toDouble()
        var minSalario = horaSalario / 60.0

        var tempoMin = editTempo.text.toString()
        var tempoH = tempoMin.toInt()

        var numero = minSalario * tempoH
        var resultado = String.format("%.2f", numero)

        textResultado.text = "Parabéns! Você transformou sua barrigada em R$ ${resultado}"
    }*/

/*
    private fun valCampos(vSalario: String, vTempo: String, vHoras: String): Boolean{
        textInputSalario.error= null
        textInputTempo.error = null
        textInputHrsTrab.error = null

        if (vSalario.isEmpty()){
            textInputSalario.error = "Digite o seu salário"
            return false
        }else if (vHoras.isEmpty()){
            textInputHrsTrab.error = "Digite Horas Trabalhadas mensais"
            return false
        }else if (vTempo.isEmpty()){
            textInputTempo.error = "Digite o tempo da sua barrigada"
            return false
        }
        return true
    }
*/


    private fun inicializarComponentesInterface() {
        textInputTempo = findViewById(R.id.text_input_tempo)
        editTempo = findViewById(R.id.edit_tempo)
        textInputSalario = findViewById(R.id.text_input_salario)
        editSalario = findViewById(R.id.edit_salario)
        textInputHrsTrab = findViewById(R.id.text_hrs_trab)
        editHrsTrab = findViewById(R.id.editHorasTrab)
        textInputData = findViewById(R.id.text_input_data)
        editData = findViewById(R.id.edit_data)
        //textResultado = findViewById(R.id.text_result)
        btnCalcular = findViewById(R.id.btn_calcular)

    }
}