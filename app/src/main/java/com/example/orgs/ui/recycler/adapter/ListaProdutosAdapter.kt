package com.example.orgs.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produtos

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produtos>
    ) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    //responsavel por mostra implementação de layout
    class ViewHolder (view:View): RecyclerView.ViewHolder(view) {


        fun vincula(produto: Produtos) {

            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    //responsavel por mostrar todos os itens dentro do layout que vamos exibir a recyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflador = LayoutInflater.from(context)
        val view = inflador.inflate(R.layout.produto_item,parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val produto = produtos [position]
        holder.vincula(produto)
    }
    override fun getItemCount(): Int  = produtos.size

    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()

    }
}
