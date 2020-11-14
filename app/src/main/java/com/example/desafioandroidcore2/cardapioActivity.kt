package com.example.desafioandroidcore2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore2.domain.Prato
import com.example.desafioandroidcore2.domain.Restaurante
import kotlinx.android.synthetic.main.activity_cardapio.*

class cardapioActivity : AppCompatActivity(), pratoAdapter.OnPratoClickListener {

    var listPrato: ArrayList<Prato> = getPrato()
    var adapter: pratoAdapter = pratoAdapter(listPrato, this)
    var TAG = "Cardapio"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        setSupportActionBar(toolbarC)

        toolbarC.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        rvCardapioC1.adapter = adapter
        rvCardapioC1.layoutManager = LinearLayoutManager(this)
        rvCardapioC1.setHasFixedSize(true)


        val restaurant = intent.getSerializableExtra("restaurante") as? Restaurante
        tvNomeRestauranteC.text = restaurant!!.nome
        ivImgRestauranteC.setImageResource(restaurant.img)



    }

    fun getPrato():ArrayList<Prato>{
        return arrayListOf(
                Prato(1,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(2,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(3,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(4,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(5,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs.")
        )
    }

    override fun pratoClick(position: Int) {
        val prato = listPrato.get(position)
        var nomePrato = prato.nome
        var descPrato = prato.descricao
        adapter.notifyItemChanged(position)

    }


}




