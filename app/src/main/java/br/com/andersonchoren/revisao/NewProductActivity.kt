package br.com.andersonchoren.revisao

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.andersonchoren.revisao.databinding.ActivityNewProductBinding

class NewProductActivity : AppCompatActivity() {
    private lateinit var newProductBinding: ActivityNewProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newProductBinding = ActivityNewProductBinding.inflate(layoutInflater)
        setContentView(newProductBinding.root)

        setSupportActionBar(newProductBinding.newProductToolbar).apply {
            title = resources.getString(R.string.label_new_product)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        newProductBinding.fabSave.setOnClickListener {
            view ->

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}