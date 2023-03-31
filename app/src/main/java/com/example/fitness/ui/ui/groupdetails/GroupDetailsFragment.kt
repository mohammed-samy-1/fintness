package com.example.fitness.ui.ui.groupdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.adapter.MembersAdapter
import com.example.fitness.databinding.FragmentGroupDetailsBinding
import com.example.fitness.models.Member

class GroupDetailsFragment : Fragment() {
lateinit var binding : FragmentGroupDetailsBinding
val adapter : MembersAdapter by lazy { MembersAdapter() }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var members = listOf(Member(name ="jon" ,img=R.drawable.photo1),
            Member(name ="lilia" ,img=R.drawable.photo2),
            Member(name ="Tomas" ,img=R.drawable.photo3),
            Member(name ="ola" ,img=R.drawable.photo4),
            Member(name ="Mossad" ,img=R.drawable.photo5),
            Member(name ="Ahmed" ,img=R.drawable.photo6))
        adapter.submitList(members)
        binding.recyclerMembers.adapter = adapter

        binding.textViewLeft.setOnClickListener {
            findNavController().navigate(R.id.action_groupDetailsFragment_to_allGroupsFragment)
        }
    }



}