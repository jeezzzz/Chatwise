package com.jeezzzz.chatwise.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeezzzz.chatwise.Models.SubModels.Product
import com.jeezzzz.chatwise.R
import com.jeezzzz.chatwise.Screens.DescriptionActivity

class ProductAdapter(val context: Activity, val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title=itemView.findViewById<TextView>(R.id.productTitle)
        var description=itemView.findViewById<TextView>(R.id.productDescription)
        var thumbnail=itemView.findViewById<ImageView>(R.id.productThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.custom_product_tile,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.title.text=products[position].title
        holder.description.text=products[position].description
        Glide.with(context).load(products[position].thumbnail).into(holder.thumbnail)


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java).apply {
                putExtra("title", product.title)
                putExtra("description", product.description)
                putExtra("thumbnail", product.thumbnail)
                putExtra("category", product.category)
                putExtra("warrantyInformation", product.warrantyInformation)
                putExtra("shippingInformation", product.shippingInformation)
                putExtra("price", product.price)
                putExtra("discountPercentage", product.discountPercentage)
                putExtra("rating", product.rating)
                putExtra("returnPolicy", product.returnPolicy)
                putExtra("availabilityStatus", product.availabilityStatus)
            }
            context.startActivity(intent)
        }
    }
}