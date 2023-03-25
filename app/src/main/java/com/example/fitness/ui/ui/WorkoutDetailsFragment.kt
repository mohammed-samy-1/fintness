package com.example.fitness.ui.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitness.R

class WorkoutDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = WorkoutDetailsFragment()
    }

    private lateinit var viewModel: WorkoutDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WorkoutDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}