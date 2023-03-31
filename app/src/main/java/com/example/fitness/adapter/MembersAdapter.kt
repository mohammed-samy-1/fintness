package com.example.fitness.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitness.databinding.MemberHolderBinding
import com.example.fitness.models.Member

class MembersAdapter : ListAdapter<Member, MembersAdapter.viewholder>() {
    class viewholder(var binding: MemberHolderBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Member){
            binding.txtUsername.text = data.name
            Glide.with(binding.root).load(data.img).into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(MemberHolderBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(getItem(position))
    }
}