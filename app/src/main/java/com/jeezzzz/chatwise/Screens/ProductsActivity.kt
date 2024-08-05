package com.jeezzzz.chatwise.Screens

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jeezzzz.chatwise.Interfaces.ApiInterface
import com.jeezzzz.chatwise.Models.MyProducts
import com.jeezzzz.chatwise.Adapters.ProductAdapter
import com.jeezzzz.chatwise.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsActivity : AppCompatActivity() {
    private lateinit var baseURL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        baseURL = "https://dummyjson.com/"

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        progressBar.visibility = View.VISIBLE

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUserData()

        retrofitData.enqueue(object : Callback<MyProducts?> {
            override fun onResponse(call: Call<MyProducts?>, response: Response<MyProducts?>) {
                val responseBody = response.body()
                val productList = responseBody?.products!!

                val productAdapter = ProductAdapter(this@ProductsActivity, productList)
                recyclerView.adapter = productAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@ProductsActivity)

                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<MyProducts?>, t: Throwable) {
                progressBar.visibility = View.GONE
                // Handle error here
            }
        })
    }
}
