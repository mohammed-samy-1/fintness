package com.example.fitness.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.fitness.databinding.StepHolderBinding
import com.example.fitness.models.Group
import com.example.fitness.ui.ui.dashboard.DashboardFragmentDirections

class StepsAdapter() : ListAdapter<String, StepsAdapter.viewholder>(Companion) {

    companion object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

    }

    class viewholder(var binding:StepHolderBinding) :ViewHolder(binding.root){

        fun bind(data:String){
            binding.txtDesc.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding =
            StepHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }



    override fun onBindViewHolder(holder: viewholder, position: Int) {
       holder.bind(getItem(position))
       holder.binding.stepNumber.text = (position+1).toString()
    }
}