package br.com.andersonchoren.revisao.service

import br.com.andersonchoren.revisao.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("/products")
    fun findProducts(): Call<List<Product>>
}