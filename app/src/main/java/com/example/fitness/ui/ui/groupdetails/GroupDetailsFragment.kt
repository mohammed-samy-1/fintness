package com.example.fitness.ui.ui.groupdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitness.R

class GroupDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = GroupDetailsFragment()
    }

    private lateinit var viewModel: GroupDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_group_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GroupDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}