package com.jeezzzz.chatwise.Screens

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jeezzzz.chatwise.R

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val thumbnail = intent.getStringExtra("thumbnail")
        val category = intent.getStringExtra("category")
        val warrantyInformation = intent.getStringExtra("warrantyInformation")
        val shippingInformation = intent.getStringExtra("shippingInformation")
        val price = intent.getDoubleExtra("price",0.0)
        val discountPercentage = intent.getStringExtra("discountPercentage")
        val rating = intent.getDoubleExtra("rating",0.0)
        val returnPolicy = intent.getStringExtra("returnPolicy")
        val availabilityStatus = intent.getStringExtra("availabilityStatus")

        Log.d("DescriptionActivity", "Title: $price")

        val titleTextView = findViewById<TextView>(R.id.productTitle)
        val descriptionTextView = findViewById<TextView>(R.id.productDescription)
        val thumbnailImageView = findViewById<ImageView>(R.id.productThumbnail)
        val categoryTextView = findViewById<TextView>(R.id.productCategory)
        val warrantyTextView = findViewById<TextView>(R.id.productWarrantyInformation)
        val shippingTextView = findViewById<TextView>(R.id.productShippingInformation)
        val priceTextView = findViewById<TextView>(R.id.productPrice)
        val discountTextView = findViewById<TextView>(R.id.productDiscountPercentage)
        val ratingTextView = findViewById<TextView>(R.id.productRating)
        val returnPolicyTextView = findViewById<TextView>(R.id.productReturnPolicy)
        val availabilityStatusTextView = findViewById<TextView>(R.id.productAvailabilityStatus)

        titleTextView.text = title
        descriptionTextView.text = description
        Glide.with(this).load(thumbnail).into(thumbnailImageView)
        categoryTextView.text = category
        warrantyTextView.text = warrantyInformation
        shippingTextView.text = shippingInformation
        priceTextView.text = price.toString()
        discountTextView.text = discountPercentage
        ratingTextView.text = rating.toString()
        returnPolicyTextView.text = returnPolicy
        availabilityStatusTextView.text = availabilityStatus
    }
}
