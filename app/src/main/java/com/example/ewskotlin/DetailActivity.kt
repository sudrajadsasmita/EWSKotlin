package com.example.ewskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.ewskotlin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load(R.drawable.logo)
            .apply(RequestOptions().override(100, 150))
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageView)
        binding.webview.loadUrl("http://ews.pasuruankota.go.id")

    }
}