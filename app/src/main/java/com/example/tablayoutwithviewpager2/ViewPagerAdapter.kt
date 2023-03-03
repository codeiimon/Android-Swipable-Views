package com.example.tablayoutwithviewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayoutwithviewpager2.databinding.ItemViewHolderBinding

class ViewPager2Adapter(
    val img : List<Int>
) : RecyclerView.Adapter<ViewPager2Adapter.ViewPager2ViewHolder>() {

    inner class ViewPager2ViewHolder(val binding: ItemViewHolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewHolderBinding.inflate(layoutInflater,parent,false)
        return ViewPager2ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPager2ViewHolder, position: Int) {
        val curImage = img[position]
        holder.binding.ivImage.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return img.size
    }
}