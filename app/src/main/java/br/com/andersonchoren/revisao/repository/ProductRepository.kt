package br.com.andersonchoren.revisao.repository

import android.util.Log
import android.widget.Toast
import br.com.andersonchoren.revisao.model.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductRepository {
    fun listProducts(
        onSuccess: (products: List<Product>) -> Unit,
        onFail: (message: String) -> Unit
    ) {
        val products: MutableList<Product> = mutableListOf()
        val db = Firebase.firestore

        db.collection("products").get().addOnSuccessListener { result ->
            for (product in result) {
                products.add(
                    Product(
                        product.id,
                        product.get("name").toString(),
                        product.get("price") as Long
                    )
                )
            }
            onSuccess(products)
        }.addOnFailureListener {
            onFail("Erro ao listar os dados")
        }
    }

    fun insertProduct(product: Product, onSuccess: (msg:String) -> Unit, onFail: (msg:String) -> Unit) {
        val db = Firebase.firestore

        val map = hashMapOf("name" to product.name, "price" to product.price)

        db.collection("products").add(map).addOnSuccessListener { reference ->
            onSuccess("Cadastrado sobre o ID: ${reference.id}!!!")
        }.addOnFailureListener {
            onFail("Deu ruim!!!")
        }
    }

    fun  editProduct(product: Product, onSuccess: (msg:String) -> Unit, onFail: (msg:String) -> Unit){
        val db = Firebase.firestore
        val map = hashMapOf("name" to product.name, "price" to product.price)
        val document = db.collection("products").document(product.id!!)
        document.set(map).addOnSuccessListener { reference ->
            onSuccess("Produto atualizado com sucesso!!!")
        }.addOnFailureListener {
            onFail("Deu ruim!!!")
        }
    }
}