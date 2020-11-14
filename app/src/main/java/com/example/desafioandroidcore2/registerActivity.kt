package com.example.desafioandroidcore2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafioandroidcore2.domain.Usuario
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btRegister.setOnClickListener(){
            getInformationUser()
        }
    }
    fun getInformationUser(): Usuario {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val senha1 = etPassword.text.toString()
        val senha2 = etRPassword.text.toString()
        var usuario = Usuario(1, email,name, senha1)

        if (checkPassword(senha1, senha2)){
            showToast("Usuário registrado!")
            callHome(usuario)
        }
        else{
            showToast("Senhas diferentes!")
        }

        return usuario
    }

    fun checkPassword(s1: String, s2: String): Boolean {
        return s1 == s2
    }

    fun callHome(usuario: Usuario) {
        var intent = Intent(this, homeActivity::class.java)
        intent.putExtra("usuarioR", usuario)
        startActivity(intent)

    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
