package br.com.andersonchoren.revisao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andersonchoren.revisao.databinding.ActivityMainBinding
import br.com.andersonchoren.revisao.model.ProductAdapter
import br.com.andersonchoren.revisao.repository.ProductRepository

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setSupportActionBar(mainBinding.mainToolbar).apply {
            title = resources.getString(R.string.label_main_title)
        }

        mainBinding.fabAdd.setOnClickListener {
            view ->
            val intent = Intent(this,NewProductActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        (ProductRepository()).listProducts({
                products ->
            mainBinding.rcProducts.apply {
                adapter = ProductAdapter(products) { id,name,price ->
                    val intent = Intent(this@MainActivity,EditProductActivity::class.java)
                    intent.putExtra("productID", id)
                    intent.putExtra("productName", name)
                    intent.putExtra("productPrice", price)
                    startActivity(intent)
                }
                layoutManager = LinearLayoutManager(applicationContext)
            }
        },{
                msg ->
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        })
    }
}