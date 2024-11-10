package com.daniellanunes.barrigadarmunerada

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DadosAdapter (private val lista : MutableList<Dados> ): Adapter<DadosAdapter.DadosViewHolder>() {

    inner class DadosViewHolder (val itemView : View) : ViewHolder (itemView){
        val textData : TextView = itemView.findViewById(R.id.text_card_data)
        val textTempo : TextView = itemView.findViewById(R.id.text_card_tempo)
        val textValor : TextView = itemView.findViewById(R.id.text_card_valor)
        val cardPerfil : CardView = itemView.findViewById(R.id.cardd_view_perfil)
        val imagePerfil : ImageView = itemView.findViewById(R.id.image_card_cagao)


        fun bind (dados: Dados){

            val context = imagePerfil.context
            imagePerfil.setOnClickListener{
                Toast.makeText(context, "CAGÃO", Toast.LENGTH_SHORT).show()
            }
            val context2 = cardPerfil.context
            cardPerfil.setOnClickListener{
                Toast.makeText(context2, "CAGÃO", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DadosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_cardview, parent, false)

        return  DadosViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: DadosViewHolder, position: Int) {
        val dados = lista[position]
        holder.bind(dados)
        holder.textData.text = dados.data
        holder.textTempo.text = dados.tempo
        holder.textValor.text = dados.valor


    }


    override fun getItemCount(): Int {
        return lista.size
    }

    fun adicionarDados(dados: Dados){

        lista.add(dados)
        notifyItemInserted(lista.size - 1)
    }


}