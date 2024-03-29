package com.example.fitness.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.fitness.databinding.CatigoryItemHolderBinding
import com.example.fitness.databinding.GroupesItemHolderBinding
import com.example.fitness.models.DataItem
import com.example.fitness.models.Group
import com.example.fitness.ui.ui.dashboard.DashboardFragmentDirections

class SportsAdapter(var items: List<DataItem>) : RecyclerView.Adapter<SportsAdapter.viewholder>() {

    class viewholder(var binding:CatigoryItemHolderBinding) :ViewHolder(binding.root){

        fun bind(data:DataItem){
            binding.txtName.text = data.name
            Glide.with(binding.root).load(data.photo).into(binding.sportImg)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding =
            CatigoryItemHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       holder.bind(items[position])
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(DashboardFragmentDirections.actionNavigationDashboardToWorkoutDetailsFragment(items[position]))
        }
    }
}