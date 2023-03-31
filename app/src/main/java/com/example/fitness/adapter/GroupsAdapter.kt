package com.example.fitness.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.GroupesItemHolderBinding
import com.example.fitness.models.Group
import com.example.fitness.ui.auth.binding
import com.example.fitness.utils.Constants

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
        holder.itemView.setOnClickListener {
            lateinit var dialog: Dialog
            dialog = Dialog(holder.itemView.context)
            dialog.setContentView(R.layout.join_dialog)
            dialog.setCancelable(false)
            val join = dialog.findViewById<Button>(R.id.btnJoin)
            val cancel = dialog.findViewById<Button>(R.id.btnCancel)

            join.setOnClickListener {
                dialog.dismiss()
            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()


        }
    }
}