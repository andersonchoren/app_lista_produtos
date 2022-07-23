package br.com.andersonchoren.revisao.model

import java.io.Serializable

data class Product(
    val id:String? = null,
    val name:String,
    val price:Long
):Serializable