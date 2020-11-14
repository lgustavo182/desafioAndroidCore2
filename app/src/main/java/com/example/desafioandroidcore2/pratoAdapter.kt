package com.example.desafioandroidcore2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore2.domain.Prato

class pratoAdapter (var listPrato: ArrayList<Prato>, val listener: OnPratoClickListener): RecyclerView.Adapter<pratoAdapter.PratoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratoViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_prato, parent,false)
        return PratoViewHolder(itemView)
    }


    override fun getItemCount() = listPrato.size

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        var prato = listPrato.get(position)
        holder.ivImgPrato.setImageResource(prato.img)
        holder.tvNomePrato.text = prato.nome

    }

    interface OnPratoClickListener{
        fun pratoClick(position: Int)
    }

    inner class PratoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val ivImgPrato: ImageView = itemView.findViewById(R.id.ivImgPrato)
        val tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.pratoClick(position)

        }

    }

} 