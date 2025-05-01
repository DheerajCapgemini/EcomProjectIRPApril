package com.demo.ecomirpapril.api

import com.demo.ecomirpapril.model.Product
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("products")
    suspend fun getProducts(
    ) : Response<List<Product>>
}
