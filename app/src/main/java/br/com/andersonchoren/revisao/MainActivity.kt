package br.com.andersonchoren.revisao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andersonchoren.revisao.client.ProductClientAPI
import br.com.andersonchoren.revisao.databinding.ActivityMainBinding
import br.com.andersonchoren.revisao.model.Product
import br.com.andersonchoren.revisao.model.ProductAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setSupportActionBar(mainBinding.mainToolbar).apply {
            title = resources.getString(R.string.label_main_title)
        }

        ProductClientAPI().findProducts({
            products ->
            if ((products != null) && products.isNotEmpty()){
                mainBinding.rcProducts.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    setHasFixedSize(true)
                    itemAnimator = DefaultItemAnimator()
                    adapter = ProductAdapter(products)
                }
            }
        },{
            error ->
            Toast.makeText(applicationContext,error,Toast.LENGTH_SHORT).show()
        })

        mainBinding.fabAdd.setOnClickListener {
            view ->
            val intent = Intent(this,NewProductActivity::class.java)
            startActivity(intent)
        }
    }
}