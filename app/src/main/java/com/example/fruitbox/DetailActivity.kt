package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.fruitbox.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data buah dari Intent
        val fruitName = intent.getStringExtra("FRUIT_NAME")
        val fruitPrice = intent.getStringExtra("FRUIT_PRICE")
        val fruitDetail = intent.getStringExtra("FRUIT_DETAIL")
        val fruitImage = intent.getStringExtra("FRUIT_IMAGE")

        // Menetapkan data buah ke antarmuka pengguna
        Glide.with(this)
            .load(fruitImage) // Assuming data.gambar is the image URL
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .apply(RequestOptions().circleCrop())
            .into(binding.imgDetail)

        binding.tvdetaildesc.text = fruitDetail
        binding.tvdetailnama.text = fruitName
        binding.tvdetailharga.text = fruitPrice

    }
}