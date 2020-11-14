package com.example.desafioandroidcore2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore2.domain.Restaurante

class restauranteAdapter(var listRestaurante: ArrayList<Restaurante>, val listener: OnRestauranteClickListener): RecyclerView.Adapter<restauranteAdapter.RestauranteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_restaurante, parent,false)
        return RestauranteViewHolder(itemView)
    }



    override fun getItemCount() = listRestaurante.size

        override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
            var restaurante = listRestaurante.get(position)
            holder.ivImgRestaurante.setImageResource(restaurante.img)
            holder.tvNomeRestaurante.text = restaurante.nome
            holder.tvEnderecoRestaurante.text = restaurante.endereco
            holder.tvHorarioFechamento.text = restaurante.horarioFechamento

    }

    interface OnRestauranteClickListener{
        fun restauranteClick(position: Int)
    }

    inner class RestauranteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val ivImgRestaurante: ImageView = itemView.findViewById(R.id.ivImgRestaurante)
        val tvNomeRestaurante: TextView = itemView.findViewById(R.id.tvNomeRestaurante)
        val tvEnderecoRestaurante: TextView = itemView.findViewById(R.id.tvEnderecoRestaurante)
        val tvHorarioFechamento: TextView = itemView.findViewById(R.id.tvHorarioFechamento)

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.restauranteClick(position)

        }

    }

}