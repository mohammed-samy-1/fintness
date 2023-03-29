package com.example.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.fitness.databinding.GroupesItemHolderBinding
import com.example.fitness.models.Group

class GroupsAdapter(var items: List<Group>) : RecyclerView.Adapter<GroupsAdapter.viewholder>() {

    class viewholder(var binding:GroupesItemHolderBinding) :ViewHolder(binding.root){

        fun bind(data:Group){
            binding.groupName.text = data.name
            Glide.with(binding.root).load(data.image).into(binding.groupImg)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding =
            GroupesItemHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       holder.bind(items[position])
    }
}