package com.jeezzzz.chatwise.Interfaces

import com.jeezzzz.chatwise.Models.MyProducts
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("products")
    fun getUserData(): Call<MyProducts>
}