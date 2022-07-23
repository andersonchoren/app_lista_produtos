package br.com.andersonchoren.revisao.utils

import br.com.andersonchoren.revisao.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIUtils {
    companion object {
        //private val BASE_URL = "http://10.0.2.2:3000"
        private val BASE_URL = "http://10.0.3.2:3000"
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productService by lazy { retrofit.create(ProductService::class.java) }
}