package com.example.ewskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.ewskotlin.Model.Bridge
import com.example.ewskotlin.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listMenu: ArrayList<Bridge> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listMenu.addAll(MenuData.listData)
        showRecyclerView(listMenu)

        Glide.with(this)
            .load(R.drawable.logo)
            .apply(RequestOptions().override(100, 150))
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageView)
    }

    private fun showRecyclerView(listMenu: ArrayList<Bridge>) {
        val adapter = MenuAdapter()
        adapter.setData(listMenu)
        binding.rvMenu.layoutManager = GridLayoutManager(this, 2)
        binding.rvMenu.adapter = adapter
        adapter.onItemCLickCallback(object : OnItemClickCallback {
            override fun onItemCLicked(bridge: Bridge) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("bridge", bridge)
                startActivity(intent)
            }
        })
    }
}