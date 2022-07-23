package br.com.andersonchoren.revisao.model

import java.io.Serializable

data class Product(
    val id:Long,
    val name:String,
    val price:Double
):Serializable