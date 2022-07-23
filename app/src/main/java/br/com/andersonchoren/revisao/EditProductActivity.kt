package br.com.andersonchoren.revisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.andersonchoren.revisao.databinding.ActivityEditProductBinding
import br.com.andersonchoren.revisao.model.Product
import br.com.andersonchoren.revisao.repository.ProductRepository

class EditProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("productID")
        val name = intent.getStringExtra("productName")
        val price = intent.getLongExtra("productPrice", 0)

        binding.edtID.setText(id)
        binding.edtName.setText(name)
        binding.edtPrice.setText(price.toString())

        binding.fabSave.setOnClickListener {
            val id = binding.edtID.text.toString()
            val name = binding.edtName.text.toString()
            val price =  (binding.edtPrice.text.toString()).toLong()

            val product = Product(id, name, price)
            (ProductRepository()).editProduct(product, { msg ->
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }, { msg ->
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            })
        }
    }
}