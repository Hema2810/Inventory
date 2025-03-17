package com.example.inventory

import android.content.Context
import android.widget.Toast
import retrofit.*

class ApiCall {
    fun getItems(context: Context, callback: (List<Item>) -> Unit) {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://fetch-hiring.s3.amazonaws.com/").addConverterFactory(
            GsonConverterFactory.create()).build()

        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        val call: Call<List<Item>> = service.getItems()

        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(response: Response<List<Item>>?, retrofit: Retrofit?) {
                if(response!!.isSuccess){
                    val items:List<Item> = response.body() as List<Item>
                    callback(items.filter{ it.name != null && it.name != "" }.sortedWith(
                        compareBy<Item> { it.listId }.thenBy { it.name }))
                }
                else{
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
