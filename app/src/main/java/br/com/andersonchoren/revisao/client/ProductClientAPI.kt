package br.com.andersonchoren.revisao.client

import br.com.andersonchoren.revisao.model.Product
import br.com.andersonchoren.revisao.service.ProductService
import br.com.andersonchoren.revisao.utils.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductClientAPI {
    companion object{
        private val productService: ProductService = APIUtils().productService
    }

    fun findProducts(
        onSuccess: (products:List<Product>?) -> Unit,
        onFail: (error:String?) -> Unit
    ) {
        productService.findProducts().enqueue(
            object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    onSuccess(response.body())
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    onFail(t.message)
                }
            }
        )
    }
}