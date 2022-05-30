package com.example.orgs.dao

import com.example.orgs.model.Produtos

class ProdutosDao {

    fun add (produto:Produtos){
        produtos.add(produto)

    }
    fun buscaTodos(): List<Produtos>{
        return produtos.toList()

    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }
}