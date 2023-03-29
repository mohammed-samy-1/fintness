package com.example.fitness.ui.ui.groups

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.fitness.adapter.GroupsAdapter
import com.example.fitness.databinding.FragmentAllGroupsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllGroupsFragment : Fragment() {

lateinit var binding: FragmentAllGroupsBinding
lateinit var  adapter :GroupsAdapter
val viewModel: GroupsViewModel by viewModels()

val type : AllGroupsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentAllGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.stateGroup.collect{
                adapter = GroupsAdapter(it.allGroups)
                binding.recyclerGroups.adapter = adapter
            }
        }



    }


}