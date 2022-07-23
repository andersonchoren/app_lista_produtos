package br.com.andersonchoren.revisao.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.andersonchoren.revisao.R

class ProductAdapter(private val products:List<Product>,private val callback:(id:String,name:String,price:Long)->Unit) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvID:TextView = view.findViewById(R.id.tvID)
        val tvName:TextView = view.findViewById(R.id.tvName)
        val tvPrice:TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        holder.tvID.text = product.id.toString()
        holder.tvName.text = product.name
        holder.tvPrice.text = product.price.toString()
        holder.itemView.setOnClickListener {
            callback(product.id!!,product.name,product.price)
        }
    }

    override fun getItemCount(): Int = products.size
}