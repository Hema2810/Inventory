package com.example.inventory
import retrofit.Call
import retrofit.http.GET

interface ApiService {
        @GET("hiring.json")
        fun getItems(): Call<List<Item>>

}