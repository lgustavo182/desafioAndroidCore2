package com.example.desafioandroidcore2.domain

import java.io.Serializable


class Usuario(val id: Int, var email: String, var senha: String):Serializable{
    var name = ""

    constructor ( id: Int, email: String, name: String, senha: String): this(id, email,senha){
        this.name= name
    }


    override fun toString(): String {
        return "Usuario(id=$id, email =$email, userName=$name, senha= $senha)"
    }
}