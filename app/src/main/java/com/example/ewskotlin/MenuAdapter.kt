package com.example.ewskotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.ewskotlin.Model.Bridge
import com.example.ewskotlin.databinding.ItemMenuBinding

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    val listMenu = ArrayList<Bridge>()

    private var onItemClickCallback: OnItemClickCallback? = null
    fun onItemCLickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(listMenu: List<Bridge>) {
        this.listMenu.clear()
        this.listMenu.addAll(listMenu)
        notifyDataSetChanged()
    }

    inner class MenuViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listMenu: Bridge) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(listMenu.logo)
                    .apply( RequestOptions().override(360, 360))
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgLogo)

                binding.tvBridge.text = listMenu.menuName
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemCLicked(listMenu)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val view = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) =
        holder.bind(listMenu[position])

    override fun getItemCount(): Int = listMenu.size
}

interface OnItemClickCallback {
    fun onItemCLicked(bridge: Bridge)
}