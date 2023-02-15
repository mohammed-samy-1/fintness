package com.example.fitness.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.constants.Constants
import com.example.fitness.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment() {

lateinit var binding: FragmentResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentResetPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnSubmit.setOnClickListener {

            Constants.showCustomAlertDialog(requireContext(),R.layout.dialog_done,true)
        }
    }


}