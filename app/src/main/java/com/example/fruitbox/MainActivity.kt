package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.fruitbox.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterFruit: FruitAdapter

    // Initialize the adapter with an empty list
    private var fruitList: List<Fruit> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        generateFruitData()
        // Initialize the FruitAdapter with an empty list
        adapterFruit = FruitAdapter(emptyList()) { fruit ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("FRUIT_NAME", fruit.name)
            intent.putExtra("FRUIT_IMAGE", fruit.gambar)
            intent.putExtra("FRUIT_DETAIL", fruit.detail)
            intent.putExtra("FRUIT_PRICE", fruit.harga.toString())
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Anda Memilih ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvMain.apply {
                adapter = adapterFruit
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            }
        }


    }

    private fun generateFruitData() {
        val retrofit = RetrofitClient.instance
        val service = retrofit.create(FruitApiService::class.java)
        val call = service.getFruitsData()

        call.enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                if (response.isSuccessful) {
                    val fruitList = response.body()
//                    Log.d("bodyku", fruitList.toString())
                    fruitList?.let {
                        adapterFruit.updateData(it)
                        Toast.makeText(this@MainActivity, "sukse", Toast.LENGTH_SHORT).show()

                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("NetworkError", "Error: ${t.message}", t)
            }
        })
    }
}
