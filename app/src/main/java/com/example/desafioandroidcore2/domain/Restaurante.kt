package com.example.desafioandroidcore2.domain

import java.io.Serializable

class Restaurante(val id:Int, var nome:String, var endereco: String, var horarioFechamento:String, var img:Int):Serializable {
    override fun toString(): String {
        return "Restaurante(id=$id, nome=$nome, endereco= $endereco, horarioFechamento= $horarioFechamento)"
    }
}