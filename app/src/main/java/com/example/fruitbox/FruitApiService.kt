package com.example.fruitbox

import retrofit2.Call
import retrofit2.http.GET

interface FruitApiService {
    @GET("fruit.json")
    fun getFruitsData(): Call<List<Fruit>>
}
