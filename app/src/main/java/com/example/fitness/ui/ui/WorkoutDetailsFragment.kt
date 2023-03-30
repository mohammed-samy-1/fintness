package com.example.fitness.ui.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.fitness.adapter.StepsAdapter
import com.example.fitness.databinding.FragmentWorkoutDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkoutDetailsFragment : Fragment() {

  val data :WorkoutDetailsFragmentArgs by navArgs()

    private val viewModel: WorkoutDetailsViewModel by viewModels()
    lateinit var binding: FragmentWorkoutDetailsBinding
     val adapter: StepsAdapter by lazy { StepsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.e( "onViewCreated: ",data.sport.toString())
        collectData()
    }

    private fun collectData(){
     lifecycleScope.launch {
         viewModel.getSpecificSports(data.sport.id!!)
         viewModel.state.collect {
                binding.sportName.text = it.specificSport?.name
                binding.txtDesc.text = it.specificSport?.description
                binding.txtDifAndCal.text = "${it.specificSport?.diffculty}|300 Calories Burn"
              Glide.with(requireContext()).load(it.specificSport?.photo).into(binding.sportImg)
             adapter.submitList(it.specificSport?.steps)
             binding.recyclerSteps.adapter = adapter
             Log.e("collectData: ",it.specificSport?.steps.toString() )

             binding.imgPlay.setOnClickListener {view->
                 val url = it.specificSport?.link // Replace this with the URL you want to open
                 val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                requireActivity(). startActivity(intent)
             }

             binding.sportImg.setOnClickListener {view->
                 val url = it.specificSport?.link // Replace this with the URL you want to open
                 val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                 requireActivity(). startActivity(intent)
             }
         }
     }
    }



}