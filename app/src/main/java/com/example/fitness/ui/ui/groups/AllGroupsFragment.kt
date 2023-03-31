package com.example.fitness.ui.ui.groups

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.fitness.R
import com.example.fitness.adapter.GroupsAdapter
import com.example.fitness.databinding.FragmentAllGroupsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllGroupsFragment : Fragment() {

lateinit var binding: FragmentAllGroupsBinding
lateinit var  adapter :GroupsAdapter
lateinit var navController: NavController
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
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
         navController = navHostFragment.navController
        lifecycleScope.launch {
            viewModel.stateGroup.collect{
                adapter = GroupsAdapter(it.allGroups,navController)
                binding.recyclerGroups.adapter = adapter
            }
        }



    }


}